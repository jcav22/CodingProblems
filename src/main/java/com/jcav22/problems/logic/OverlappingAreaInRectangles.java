package com.jcav22.problems.logic;

import com.jcav22.problems.model.Rectangle;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class OverlappingAreaInRectangles {

    public static int getOverlappingArea(Rectangle r1, Rectangle r2) {
        return getOverlappingBase(r1, r2) * getOverlappingHeight(r1, r2);
    }

    private static int getOverlappingBase(Rectangle rectangle1, Rectangle rectangle2) {
        int xRight = min(rectangle1.getX2() ,rectangle2.getX2());
        int xLeft = max(rectangle1.getX1(), rectangle2.getX1());
        return xRight - xLeft;
    }

    private static int getOverlappingHeight(Rectangle rectangle1, Rectangle rectangle2) {
        int yTop = min(rectangle1.getY2(), rectangle2.getY2());
        int yBottom = max(rectangle1.getY1(), rectangle2.getY1());
        return yTop - yBottom;
    }
}
