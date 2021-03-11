package RuntimeTerror2021;

import java.lang.Math;

public class UtilMethods {
    public static int getManhattanDistance(Coord a, Coord b) {
        return Math.abs(a.x_col - b.x_col) + Math.abs(a.y_row - b.y_row);
    }

    public static int getAbsDiff(int int1, int int2) {
        int result = int1 - int2;
        if (result < 0) {
            result *= -1;
        }
        return result;
    }
}


