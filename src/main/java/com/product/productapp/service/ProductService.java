package com.product.productapp.service;

import com.product.productapp.model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public interface ProductService {

    Mono<Product> createProduct(Product product);
    Mono<Product> findById(int id);
    Flux<Product> findAll();
    Mono<Product> update(Product product);
    Mono<Product> delete(int id);

}
