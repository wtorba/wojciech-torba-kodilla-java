package com.kodilla.testing.shape;

public class Square implements Shape {

    private String shapeName;
    private double field;

    public Square(double field) {
        this.shapeName = "square";
        this.field = field;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return field;
    }
}
