package com.product.productapp.repository;

import com.product.productapp.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, Integer> {

    Mono<Product> findByProductName(String productName);

    Flux<Product> findAllByProductName(String productName, String productDescription);
}
