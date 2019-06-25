package com.jcav22.problems.model;

public class Rectangle {

    private Point2D point1;
    private Point2D point2;

    public Rectangle(Point2D point1, Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public int getX1() {
        return this.point1.getX();
    }

    public int getY1() {
        return this.point1.getY();
    }

    public int getX2() {
        return this.point2.getX();
    }

    public int getY2() {
        return this.point2.getY();
    }
}
