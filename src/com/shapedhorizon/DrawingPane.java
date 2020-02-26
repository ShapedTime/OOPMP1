package com.shapedhorizon;

import java.util.ArrayList;
import java.util.List;

public class DrawingPane {

    private int bgColor;
    private List<Shape> shapes;
    private PointBasic size;

    public DrawingPane(int bgColor, PointBasic size) {
        this.bgColor = bgColor;
        this.size = size;
        this.shapes = new ArrayList<>();
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public PointBasic getSize() {
        return size;
    }

    public void setSize(PointBasic size) {
        this.size = size;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void removeShape(Shape shape){
        shapes.remove(shape);
    }

    public Shape getShape(PointBasic p){
        for (Shape shape:shapes) {
            if(shape.isInside(p)) return shape;
        }
        return null;
    }


}
