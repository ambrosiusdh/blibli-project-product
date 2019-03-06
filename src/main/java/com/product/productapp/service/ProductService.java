package com.product.productapp.service;

import com.product.productapp.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    Product createProduct(Product product);
    Product findById(int id);
    List<Product> findAll();
    Product update(Product product);
    Product delete(int id);

}
