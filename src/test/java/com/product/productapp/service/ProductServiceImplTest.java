package com.product.productapp.service;

import com.product.productapp.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    private Product product1;
    private Product product2;
    private List<Product> products;

    @Before
    public void setUp() throws Exception {
        product1 = new Product(1,
                "S10",
                "Handphone",
                15,
                2000,
                "Handphone");
        product2 = new Product(2,
                "Note8",
                "Handphone",
                5,
                3000,
                "Handphone");
        products = Flux.<Product>create(sink->{
            sink.next(product1);
            sink.next(product2);
            sink.complete();
        })
            .collectList()
            .block();
        productService.createProduct(product1).block();
        productService.createProduct(product2).block();


    }

    @Test
    public void createMember() {
        assertEquals("Data harus 2", products.size(), 2);

        Mono<Product> temp = productService.findById(1);
        assertEquals("Data harus sama", product1, temp.block());
    }

    @Test
    public void findById() {

        assertNull("Data harus tidak tertemukan", productService.findById(3).block());

        assertEquals("Data harus sama", productService.findById(1).block(), product1);

    }

    @Test
    public void findAll() {
        assertEquals("List harus bersize 2", products.size(), 2);
    }

    @Test
    public void update() {
        Product temp = new Product(1,
                "Note9",
                "Handphone",
                12,
                2000,
                "Handphone");
        productService.update(temp).block();

        assertEquals("Product harus terupdate", temp, productService.findById(1).block());
    }

    @Test
    public void delete() {
        productService.delete(2).block();
        assertNotNull("Product 2 harus terhapus", productService.findById(2).block());

    }
}