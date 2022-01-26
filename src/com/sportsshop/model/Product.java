package com.sportsshop.model;

import java.util.Date;

/**
 * Store all the details of a product and it provides the single object.
 */
public class Product {
    private String name;
    private String brand;
    private float  price;
    private char   size;
    private Date   manufactureDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
	}

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
