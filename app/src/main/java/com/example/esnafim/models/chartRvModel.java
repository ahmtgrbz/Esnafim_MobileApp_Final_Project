package com.example.esnafim.models;

import java.util.Objects;

public class chartRvModel {
    private ProductlistRvmodel Product;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        chartRvModel that = (chartRvModel) o;
        return quantity == that.quantity &&
                Product.equals(that.Product);
    }

    public ProductlistRvmodel getProduct() {
        return Product;
    }

    public void setProduct(ProductlistRvmodel product) {
        Product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public chartRvModel(ProductlistRvmodel product, int quantity) {
        Product = product;
        this.quantity = quantity;
    }
}
