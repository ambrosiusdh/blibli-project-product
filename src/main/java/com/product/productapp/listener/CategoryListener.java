package com.product.productapp.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productapp.model.Category;
import com.product.productapp.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CategoryListener {

    private ObjectMapper objectMapper;
    private CategoryService categoryService;

    @Autowired
    public CategoryListener(ObjectMapper objectMapper, CategoryService categoryService) {
        this.objectMapper = objectMapper;
        this.categoryService = categoryService;
    }

    @KafkaListener(topics = "categories")
    public void listenTopicCategories(String body) throws IOException {
        Category category = objectMapper.readValue(body, Category.class);
        categoryService.createCategory(category);
        log.info("Category Created :" + "/n" + "{}", category);
    }

}