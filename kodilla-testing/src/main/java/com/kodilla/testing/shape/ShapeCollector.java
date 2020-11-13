package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapeList = new ArrayList<>();

    public boolean addFigure(Shape shape) {
        return shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        if (shapeList.size() > n) {
            return shapeList.get(n);
        }
        return null;
    }

    public String showFigures() {
        if (shapeList.size() == 0) {
            return null;
        } else {
            StringBuffer names = new StringBuffer("");
            for (Shape shape : shapeList) {
                if (!(names.toString().equals(""))) {
                    names.append(";");
                }
                names.append(shape.getShapeName());
            }
            return names.toString();
        }
    }
}
