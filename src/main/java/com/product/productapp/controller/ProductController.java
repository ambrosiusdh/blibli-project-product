package com.product.productapp.controller;

import com.product.productapp.model.Product;
import com.product.productapp.service.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product createMember(@RequestBody Product product) {
        productService.createProduct(product);
        return product;
    }

    @RequestMapping(
            value = "/product/{productId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById(@PathVariable int productId) {
        return productService.findById(productId);
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll() {
        return productService.getProducts();
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @RequestMapping(
            value = "/product/{productId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable int productId) {
        return productService.delete(productId);
    }
}
