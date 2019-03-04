package com.product.productapp;

public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private int productQty;
    private int productPrice;
    private String category;

    public Product(int productId,
                   String productName,
                   String productDescription,
                   int productQty,
                   int productPrice,
                   String category) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
