package com.product.productapp.service;

import com.product.productapp.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class ProductServiceImplTest {

    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() throws Exception {
        productService = new ProductServiceImpl();
        product1 = new Product(1,
                "S9",
                "Handphone",
                10,
                2000,
                "Handphone");
        product2 = new Product(2,
                "S10",
                "Handphone",
                5,
                3000,
                "Handphone");
        productService.createProduct(product1);
        productService.createProduct(product2);
    }

    @Test
    public void createMember() {
        assertEquals("Data harus 2", productService.findAll().size(), 2);

        Product temp = productService.findById(1);
        assertEquals("Data harus sama", product1, temp);
    }

    @Test
    public void findById() {

        assertNull("Data harus tidak tertemukan", productService.findById(3));

        assertEquals("Data harus sama", productService.findById(1), product1);

    }

    @Test
    public void findAll() {
        assertEquals("List harus bersize 2", productService.getProducts().size(), 2);
    }

    @Test
    public void update() {
        Product temp = new Product(1,
                "Note9",
                "Handphone",
                12,
                2000,
                "Handphone");
        productService.update(temp);

        assertEquals("Product harus terupdate", temp, productService.findById(1));
    }

    @Test
    public void delete() {
        productService.delete(2);
        assertFalse("Product 2 harus terhapus", productService.getProducts().contains(product2));

    }
}