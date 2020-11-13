package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private String shapeName;
    private double field;

    public Triangle( double field) {
        this.shapeName = "triangle";
        this.field = field;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return field;
    }
}
