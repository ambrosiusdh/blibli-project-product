package com.product.productapp.service;

import com.product.productapp.model.Category;
import com.product.productapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Mono<Category> createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Flux<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
