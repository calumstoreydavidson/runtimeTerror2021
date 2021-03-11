package RuntimeTerror2021;

import java.lang.Math;

public class UtilMethods {
    public static int getManhattanDistance(Coord a, Coord b) {
        return Math.abs(a.x_col - b.x_col) + Math.abs(a.y_row - b.y_row);
    }

    public static ArrayList<Coord> getCommonCoords(ArrayList<Coord> buildingA, ArrayList<Coord> buildingB) {
        ArrayList<Coord> commonCoords = buildingA.retainAll(buildingB);

        return commonCoords; 
    }
}


