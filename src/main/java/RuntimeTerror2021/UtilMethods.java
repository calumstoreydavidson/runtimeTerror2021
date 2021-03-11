package RuntimeTerror2021;

import java.lang.Math;

public class UtilMethods {
    public static int getManhattanDistance(int coordA, int coordB, int coordC, int coordD) {
        // coordA = x coordinate of point A
        // coordB = y coordinate of point A
        // coordC = x coordinate of point B
        // coordD = y coordinate of point B
        return Math.abs(coordA - coordC)  + Math.abs(coordB - coordD);
    }
}
