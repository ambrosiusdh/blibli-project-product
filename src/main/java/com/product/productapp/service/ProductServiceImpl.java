package com.product.productapp.service;

import com.product.productapp.model.Product;
import com.product.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> delete(int id) {
        return productRepository.findById(id)
                .flatMap(product -> productRepository.delete(product)
                    .thenReturn(product)
                );
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public Mono<Product> findByProductName(String productName){
        return productRepository.findByProductName(productName);
    }
}
