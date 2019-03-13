package com.product.productapp.service;

import com.product.productapp.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {

    Mono<Category> createCategory(Category category);

    Flux<Category> findAllCategory();
}
