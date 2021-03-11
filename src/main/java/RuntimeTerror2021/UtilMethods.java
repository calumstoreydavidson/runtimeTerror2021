package RuntimeTerror2021;

import java.lang.Math;
import java.util.ArrayList;

public class UtilMethods {
    public static int getManhattanDistance(Coord a, Coord b) {
        return Math.abs(a.x_col - b.x_col) + Math.abs(a.y_row - b.y_row);
    }

    public static ArrayList<Coord> getCommonCoords(ArrayList<Coord> buildingA, ArrayList<Coord> buildingB) {
        ArrayList<Coord> commonCoords = buildingA.retainAll(buildingB);

        return commonCoords; 
    }

    public static int calculateScore(Building building, Antenna antenna){
        Coord a  = new Coord(building.getX_coord(), building.getY_coord());
        Coord b  = new Coord(building.getX_coord(), antenna.getTemp_y_coord());
        int manhattenDistance = UtilMethods.getManhattanDistance(a, b);
        int score = (building.getConnectionSpeedWeight() * antenna.getConnectionSpeed()) - building.getLatencyWeight() * manhattenDistance;
        return score;
    }

    public static Coord calculateHighestScore(ArrayList<Coord> commonCords, Building building, Antenna antenna) {
        Coord highestScoringCoord = null;
        int highestScore = 0;

        for(Coord coord : commonCords) {
            antenna.setTemp_x_coord(coord.getX_col());
            antenna.setTemp_y_coord(coord.getY_row());

            int score = calculateScore(building, antenna);

            if(score > highestScore) {
                highestScore = score;
                highestScoringCoord = new Coord(coord.getX_col(), coord.getY_row());
            }
        }
        return highestScoringCoord;
    }
}


