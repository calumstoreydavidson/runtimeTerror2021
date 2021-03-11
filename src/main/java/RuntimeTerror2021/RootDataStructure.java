package RuntimeTerror2021;

import java.util.ArrayList;

public class RootDataStructure {

    private InputData inputData;

    private ArrayList<Building> buildings = new ArrayList<>();
    private ArrayList<Antenna> antennas = new ArrayList<>();

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();

    public RootDataStructure(ArrayList<String> inputLines) {
        inputData = new InputData(inputLines);

        buildDataStructures();

        test();
    }

    private void test(){
        Building building = buildings.get(2);
        ArrayList<Coord> pointsInRange = building.getPointsInRange(1, inputData.getXColumnsSize(), inputData.getYRowsSize());
        System.out.println();
        System.out.println("building at: " + building.getX_coord() + ":" + building.getY_coord());
        System.out.println("valid coords in range of 1:");
        pointsInRange.forEach(coord -> System.out.println(coord.x_col + ":" + coord.y_row));
    }


    // custom code here
    private void buildDataStructures() {
        //convert developer input lines, into developer objects, etc
        System.out.println("\n" + "Buildings:");
        inputData.getBuildingInputLines().forEach(buildingLine -> {
            buildings.add(new Building(buildingLine.get(0), buildingLine.get(1), buildingLine.get(2), buildingLine.get(3)));
            System.out.println(buildingLine);
        });

        System.out.println("\n" + "Antennas:");
        inputData.getAntennaInputLines().forEach(antennaLine -> {
            antennas.add(new Antenna(antennaLine.get(0), antennaLine.get(1)));
            System.out.println(antennaLine);
        });
        System.out.println();

    }
}
