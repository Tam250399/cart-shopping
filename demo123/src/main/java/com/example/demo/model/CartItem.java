package com.example.demo.model;

import javax.persistence.*;

public class CartItem {
    private final Product product;
    private int quantity;
    private float subTotal;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        subTotal = product.getPrice() * quantity;
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;// so luong
        this.subTotal = product.getPrice();
    }

}

