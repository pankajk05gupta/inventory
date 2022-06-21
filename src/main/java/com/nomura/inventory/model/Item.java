package com.nomura.inventory.model;

import java.math.BigDecimal;

public class Item {

    private long id;
    private String brand;
    private int size;
    private int quantity;
    private BigDecimal price;
    private boolean inStock;


    public Item() {
    }

    public Item(String brand, int size, int quantity, BigDecimal price,boolean inStock) {
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.inStock=inStock;
    }

    public Item(long id, String brand, int size, int quantity, BigDecimal price,boolean inStock) {
        this.id = id;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.inStock=inStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
