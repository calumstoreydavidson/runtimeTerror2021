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

    //    public static ArrayList<Coord> getCommonCoords(ArrayList<Coord> buildingA, ArrayList<Coord> buildingB) {
//        ArrayList<Coord> commonCoords = new ArrayList<>(buildingA);
//        commonCoords.retainAll(buildingB);
//
//        return commonCoords;
//    }
//
//    public static ArrayList<Coord> getCommonCoordsForAntenna(Antenna antenna, ArrayList<Building> buildings,
//                                                    InputData inputData) {
//        ArrayList<ArrayList<Coord>> validAntennaLocations = new ArrayList<>();
//        int range = antenna.getRange();
//        for (Building building : buildings) {
//            validAntennaLocations.add(building.getPointsInRange(range, inputData.getXColumnsSize(),
//                                                                inputData.getYRowsSize()));
//        }
//
//        ArrayList<Coord> commonCoords = new ArrayList<>(validAntennaLocations);
//        commonCoords.retainAll(buildingB);
//
//        return commonCoords;
//    }
//
//    public static ArrayList<ArrayList<Coord>> commonCoordsBetweenBuildings(ArrayList<Coord> coords, int range, InputData inputData){
//        ArrayList<ArrayList<Coord>> commonCoords = new ArrayList<>();
//        for (int i = 0; i < coords.size(); i++) {
//            for (int j = i+1; j < i; j++) {
//                commonCoords.add(getCommonCoords(getPointsInRange(range, inputData, coords.get(i)),
//                                getPointsInRange(range, inputData, coords.get(j))));
//            }
//        }
//        return commonCoords;
//    }
//
//    public static ArrayList<Coord> getPointsInRange(int range, InputData inputData, Coord coord) {
//        ArrayList<Coord> pointsInRange = new ArrayList<>();
//
//        //TODO inefficient!!!!!
//        for (int i = 0; i < inputData.getXColumnsSize(); i++) {
//            for (int j = 0; j < inputData.getYRowsSize(); j++) {
//                if (inRange(range, i, j, coord)) {
//                    pointsInRange.add(new Coord(i, j));
//                }
//            }
//        }
//
//        return pointsInRange;
//    }
//
//    //manhattan distance?
//    private static boolean inRange(int range, int x, int y, Coord coord) {
//        return UtilMethods.getManhattanDistance(coord, new Coord(x,y)) <= range;
//    }
}


