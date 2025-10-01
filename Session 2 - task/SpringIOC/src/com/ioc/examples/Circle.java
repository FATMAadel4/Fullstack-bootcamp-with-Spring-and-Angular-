package com.ioc.examples;

public class Circle implements Shape {
    private double radius;
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return 2 * Math.PI * radius;
    }
}
