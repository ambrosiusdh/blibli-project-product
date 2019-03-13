package com.product.productapp.controller;

import com.product.productapp.model.ApiKey;
import com.product.productapp.model.Product;
import com.product.productapp.service.ProductServiceImpl;
import com.product.productapp.validation.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
public class ProductController {

    private ProductServiceImpl productService;
    private ValidationHelper validationHelper;

    @Autowired
    public ProductController(ProductServiceImpl productService, ValidationHelper validationHelper) {
        this.productService = productService;
        this.validationHelper = validationHelper;
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Product> createMember(@RequestBody Product product) {
        return validationHelper.validate(product)
                .flatMap(data-> productService.createProduct(data))
                .subscribeOn(Schedulers.elastic());

    }

    @RequestMapping(
            value = "/product/{productId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Product> findById(@PathVariable int productId) {
        return productService.findById(productId);
    }

    @RequestMapping(
            value = "/database/product/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Product> findAll(ApiKey apiKey) {
        return productService.findAll();
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Product> update(@RequestBody Product product) {
        return productService.update(product);
    }

    @RequestMapping(
            value = "/database/product/{productId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Product> delete(@PathVariable int productId) {
        return productService.delete(productId);
    }
}
