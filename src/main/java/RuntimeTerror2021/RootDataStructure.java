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
