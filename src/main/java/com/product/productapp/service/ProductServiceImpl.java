package com.product.productapp.service;

import com.product.productapp.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product findById(int id) {
        for (Product p: products) {
            if(p.getProductId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product update(Product product) {
        for (Product p : products) {
            if(p.getProductId() == product.getProductId()){
                BeanUtils.copyProperties(product, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public Product delete(int id) {
        Product temp = new Product();
        for (Product p : products) {
            if(p.getProductId() == id){
                BeanUtils.copyProperties(p, temp);
                products.remove(p);
                return temp;
            }
        }
        return null;
    }
}
