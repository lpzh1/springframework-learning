package com.aop.pojo;

import lombok.Data;

@Data
public class Boss {

    private String name;
    private Car car = new Car();

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                ", name='" + name + '\'' +
                '}';
    }
}
