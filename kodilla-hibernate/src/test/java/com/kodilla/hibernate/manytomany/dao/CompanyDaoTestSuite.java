package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testEmployeeNamedQueries() {
        //Given
        Employee johnSmith = new Employee("John", "Fasola");
        Employee stephanieClarckson = new Employee("Stephanie", "Groch");
        Employee lindaKovalsky = new Employee("Linda", "Szparag");
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        //When
        List<Employee> employeeSmith = employeeDao.retrieveEmployeeByLastname("Fasola");

        //Then
        assertEquals(1, employeeSmith.size());

        //Cleanup
        employeeDao.deleteById(johnSmith.getId());
        employeeDao.deleteById(stephanieClarckson.getId());
        employeeDao.deleteById(lindaKovalsky.getId());
    }

    @Test
    void testCompanyNamedQueries() {
        //Given
        Company firma1 = new Company("Software Gods");
        Company firma2 = new Company("Data Diggers");
        Company firma3 = new Company("Data Miners");
        companyDao.save(firma1);
        companyDao.save(firma2);
        companyDao.save(firma3);
        //When
        List<Company> companiesDat = companyDao.retrieveCompaniesWithNameLike("Dat");

        //Then
        assertEquals(2, companiesDat.size());

        //Cleanup
        companyDao.deleteById(firma1.getId());
        companyDao.deleteById(firma2.getId());
        companyDao.deleteById((firma3.getId()));
    }

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}