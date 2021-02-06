package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {

        //Given
        Product prod1 = new Product("Product 1");
        Product prod2 = new Product("Product 2");
        Invoice invoice = new Invoice("Invoice 1");
        Item item1 = new Item(prod1, new BigDecimal(20), 2, new BigDecimal(40));
        Item item2 = new Item(prod2, new BigDecimal(15), 3, new BigDecimal(45));
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        productDao.save(prod1);
        productDao.save(prod2);
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);
        productDao.deleteById(prod1.getId());
        productDao.deleteById(prod2.getId());

    }
}
