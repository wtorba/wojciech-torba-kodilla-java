package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyAndEmployeeFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void CompanyAndEmployeeFacadeCompany() {
       //Given
       CompanyAndEmployeeFacade companyAndEmployeeFacade = new CompanyAndEmployeeFacade(companyDao, employeeDao);
       Company mlecznaKraina = new Company("MlecznaKraina");
       Company mlecznaDolina = new Company("MlecznaDolina");
       companyDao.save(mlecznaDolina);
       companyDao.save(mlecznaKraina);

       //When
        List<Company> olinaCompanies = companyAndEmployeeFacade.getCompaniesLike("olina");

        //Then
        assertEquals(1, olinaCompanies.size());

        if ( olinaCompanies.size() == 1 ) {
            assertEquals("MlecznaDolina", olinaCompanies.get(0).getName());
        }

        //Cleanup
        companyDao.deleteById(mlecznaDolina.getId());
        companyDao.deleteById(mlecznaKraina.getId());
    }

    @Test
    void CompanyAndEmployeeFascadeEmployee() {
        //Given
        CompanyAndEmployeeFacade companyAndEmployeeFacade = new CompanyAndEmployeeFacade(companyDao, employeeDao);
        Employee janKowalski = new Employee("Jan","Kowalski");
        Employee mariaKowalska = new Employee("Maria", "Kowalska");
        Employee dariaKowalewska = new Employee("Daria","Kowalewska");
        employeeDao.save(janKowalski);
        employeeDao.save(mariaKowalska);
        employeeDao.save(dariaKowalewska);

        //When
        List<Employee> skiEmployees = companyAndEmployeeFacade.getEmployeesLike("walsk");

        //Then
        assertEquals(2, skiEmployees.size());
        List<String> resLastNames = skiEmployees.stream().map(e -> e.getLastname()).collect(Collectors.toList());
        List<String> expLastNames = new ArrayList(Arrays.asList("Kowalski","Kowalska"));
        expLastNames.retainAll(resLastNames);
        assertEquals(2, expLastNames.size());

        //Cleanup
        employeeDao.deleteById(janKowalski.getId());
        employeeDao.deleteById(mariaKowalska.getId());
    }
}
