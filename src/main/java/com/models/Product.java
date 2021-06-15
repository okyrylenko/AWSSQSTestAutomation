package com.models;

import java.math.BigDecimal;
import java.math.MathContext;

public class Product {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.round(new MathContext(3));
    }
}
