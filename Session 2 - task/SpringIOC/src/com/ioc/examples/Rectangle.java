package com.ioc.examples;

public class Rectangle implements Shape {
    private double side;
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side* side;
    }
}

