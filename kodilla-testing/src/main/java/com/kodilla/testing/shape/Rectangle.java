package com.kodilla.testing.shape;

public class Rectangle implements Shape {

    private String shapeName;
    private double field;

    public Rectangle(double field) {
        this.shapeName = "rectangle";
        this.field = field;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return field;
    }
}
