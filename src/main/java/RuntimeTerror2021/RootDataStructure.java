package RuntimeTerror2021;

import java.util.ArrayList;

public class RootDataStructure {

    private InputData inputData;

    private ArrayList<Building> buildings = new ArrayList<>();

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();

    public RootDataStructure(ArrayList<String> inputLines) {
        inputData = new InputData(inputLines);

        buildDataStructures();
    }

    // custom code here
    private void buildDataStructures() {
        //convert developer input lines, into developer objects, etc
        inputData.buildingInputLines.forEach(buildingLine -> {

        });
    }
}
