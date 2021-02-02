package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String typeTask) {
        return switch (typeTask) {
            case SHOPPING -> new ShoppingTask("Shopping", "Bread", 2);
            case PAINTING -> new PaintingTask("Painting", "red", "wall");
            case DRIVING -> new DrivingTask("Driving", "home", "fiat");
            default -> null;
        };
    }
}