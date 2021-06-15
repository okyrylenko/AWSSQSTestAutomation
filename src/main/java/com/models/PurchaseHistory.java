package com.models;

import java.util.Date;
import java.util.List;

public class PurchaseHistory {
    private List<Product> products;
    private String email;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
