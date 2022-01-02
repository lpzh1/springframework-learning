package com.aop.pojo;

import lombok.Data;

@Data
public class Car {
    private int maxSpeed;
    private String brand;
    private double price;


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", price=" + price +
                '}';
    }
}
