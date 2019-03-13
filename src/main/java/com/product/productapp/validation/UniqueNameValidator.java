package com.product.productapp.validation;

import com.product.productapp.model.Product;
import com.product.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private ProductRepository productRepository;

    @Autowired
    public UniqueNameValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }

        Product product = productRepository.findByProductName(value).block();

        return product == null;
    }
}
