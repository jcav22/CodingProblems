package com.jcav22.problems.logic;

import com.jcav22.problems.model.Rectangle;

import static java.lang.Math.max;
import static java.lang.Math.min;

class OverlappingAreaInRectangles {

    static int getOverlappingArea(Rectangle r1, Rectangle r2) {
        int base = calculateSide().apply(r1.getX2(), r2.getX2(), r1.getX1(), r2.getX1());
        int height = calculateSide().apply(r1.getY2(), r2.getY2(), r1.getY1(), r2.getY1());
        return base * height;
    }

    @FunctionalInterface
    interface CalculateSideOverlap {
        int apply(int r1x2, int r2x2, int r1x1, int r2x1);
    }

    private static CalculateSideOverlap calculateSide() {
        return (r1x2, r2x2, r1x1, r2x1) -> min(r1x2, r2x2) - max(r1x1, r2x1);
    }
}
