package RuntimeTerror2021;

import java.util.ArrayList;

import static RuntimeTerror2021.ProcessIO.DELIMITER;
import static java.util.Arrays.asList;

public class InputData {

    private int H_yRowsSize;
    private int W_xColumnsSize;
    private int N_buildingsOnGrid;
    private int M_antennasOnGrid;
    private int R_allBuildingsConnectedReward;

    private ArrayList<ArrayList<String>> buildingInputLines;
    private ArrayList<ArrayList<String>> antennaInputLines;
    private ArrayList<String> managerInputLines;

    public InputData(ArrayList<String> inputLines) {
        buildingInputLines = new ArrayList<>();
        antennaInputLines = new ArrayList<>();
        managerInputLines = new ArrayList<>();

        splitInputSections(inputLines);
    }

    private void splitInputSections(ArrayList<String> inputLines) {
        //Row 1
        ArrayList<String> gridAxis = new ArrayList<>(asList(inputLines.get(0).split(DELIMITER)));
        W_xColumnsSize = Integer.parseInt(gridAxis.get(0));
        H_yRowsSize = Integer.parseInt(gridAxis.get(1));

        //Row 2
        ArrayList<String> stuff = new ArrayList<>(asList(inputLines.get(1).split(DELIMITER)));
        N_buildingsOnGrid = Integer.parseInt(stuff.get(0));
        M_antennasOnGrid = Integer.parseInt(stuff.get(1));
        R_allBuildingsConnectedReward = Integer.parseInt(stuff.get(2));

        int N_buildingsOnGridDecrementer = N_buildingsOnGrid;
        //starts line 3 = 2
        for (int i = 2; i < inputLines.size(); i++) {

            //building map
            if (N_buildingsOnGridDecrementer > 0) {
//                inputLineGroups.add(new ArrayList<>(asList(inputLines.get(i).split(""))));
                buildingInputLines.add(new ArrayList<>(asList(inputLines.get(i).split(" "))));
//                buildingInputLines.add(inputLines.get(i));
                N_buildingsOnGridDecrementer--;
            } else {
                continue;
            }
        }

        int M_antennasOnGridDecrementer = M_antennasOnGrid;
        // starts 3 + N_buildingsOnGrid = 2 + N_buildingsOnGrid
        for (int i = N_buildingsOnGrid + 2; i < inputLines.size(); i++) {
            if (M_antennasOnGridDecrementer > 0) {
                antennaInputLines.add(new ArrayList<>(asList(inputLines.get(i).split(" "))));
//                antennaInputLines.add(inputLines.get(i));
                M_antennasOnGridDecrementer--;
            }
        }

        ArrayList<Integer> inputDataNumerics = new ArrayList<>(asList(
                W_xColumnsSize,
                H_yRowsSize,
                N_buildingsOnGrid,
                M_antennasOnGrid,
                R_allBuildingsConnectedReward));

        inputDataNumerics.forEach(System.out::println);
        System.out.println();

        buildingInputLines.forEach(System.out::println);
        System.out.println();

        antennaInputLines.forEach(System.out::println);
        System.out.println("----input consumption finished----");
        System.out.println();
    }

    public int getYRowsSize() {
        return H_yRowsSize;
    }

    public int getXColumnsSize() {
        return W_xColumnsSize;
    }

    public ArrayList<ArrayList<String>> getBuildingInputLines() {
        return buildingInputLines;
    }

    public ArrayList<ArrayList<String>> getAntennaInputLines() {
        return antennaInputLines;
    }

    public ArrayList<String> getManagerInputLines() {
        return managerInputLines;
    }
}
