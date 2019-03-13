package com.product.productapp.model;

import com.product.productapp.validation.NotZero;
import com.product.productapp.validation.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    @NotZero
    private Integer productId;

    @NotBlank
    @UniqueName(message = "Nama tidak boleh sama")
    private String productName;

    @NotBlank
    private String productDescription;

    @NotZero
    private int productQty;

    @NotZero
    private int productPrice;

    @NotBlank
    private String category;

}
