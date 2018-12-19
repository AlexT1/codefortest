package com.alexstudy.base;

import java.awt.*;

/**
 * @ClassName Polygon
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/4 15:29:39
 */
public class Polygon {
    public Polygon polygonFrom(Point... corners) {
        int numberOfSides = corners.length;
        double squareOfSide1, lengthOfSide1;
        squareOfSide1 = (corners[1].x - corners[0].x)
                * (corners[1].x - corners[0].x)
                + (corners[1].y - corners[0].y)
                * (corners[1].y - corners[0].y);
        lengthOfSide1 = Math.sqrt(squareOfSide1);

        // more method body code follows that creates and returns a
        // polygon connecting the Points
        return null;
    }
}
