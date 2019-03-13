package com.product.productapp.repository;

import com.product.productapp.model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, Integer> {

}
