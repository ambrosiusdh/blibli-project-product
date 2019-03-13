package com.product.productapp.validation;

import com.product.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotZeroValidator implements ConstraintValidator<NotZero, Integer> {

    private ProductRepository productRepository;

    @Autowired
    public NotZeroValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value != 0;
    }
}
