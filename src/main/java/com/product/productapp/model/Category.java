package com.product.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productCategory")
public class Category {

    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
}
