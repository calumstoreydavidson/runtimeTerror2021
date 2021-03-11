package calum.deskspace;

import java.util.ArrayList;

import static RuntimeTerror2021.ProcessIO.DELIMITER;
import static java.util.Arrays.asList;

public class InputData {

    private int yRowsSize;
    private int xColumnsSize;
    private int devCount;
    private int managerCount;

    ArrayList<ArrayList<String>> gridInputLines;
    ArrayList<String> devInputLines;
    ArrayList<String> managerInputLines;

    public InputData(ArrayList<String> inputLines) {
        gridInputLines = new ArrayList<>();
        devInputLines = new ArrayList<>();
        managerInputLines = new ArrayList<>();

        splitInputSections(inputLines);
    }

    private void splitInputSections(ArrayList<String> inputLines) {
        //Row 1
        ArrayList<String> gridAxis = new ArrayList<>(asList(inputLines.get(0).split(DELIMITER)));
        xColumnsSize = Integer.parseInt(gridAxis.get(0));
        yRowsSize = Integer.parseInt(gridAxis.get(1));

        int gridSizeDecrementer = yRowsSize;
        for (int i = 1; i < inputLines.size(); i++) {

            //floor map
            if (gridSizeDecrementer > 0) {
//                inputLineGroups.add(new ArrayList<>(asList(inputLines.get(i).split(""))));
                gridInputLines.add(new ArrayList<>(asList(inputLines.get(i).split(""))));
//                gridInputLines.add(inputLines.get(i));
                gridSizeDecrementer--;
            } else {
                continue;
            }
        }

        devCount = Integer.parseInt(inputLines.get(yRowsSize + 1));
        int devCountDecrementer = devCount;
        for (int i = yRowsSize + 2; i < inputLines.size(); i++) {
            if (devCountDecrementer > 0) {
                devInputLines.add(inputLines.get(i));
                devCountDecrementer--;
            }
        }

        managerCount = Integer.parseInt(inputLines.get(yRowsSize + devCount + 2));
        int managerCountDecrementer = managerCount;
        for (int i = yRowsSize + devCount + 3; i < inputLines.size(); i++) {
            if (managerCountDecrementer > 0) {
                managerInputLines.add(inputLines.get(i));
                managerCountDecrementer--;
            }
        }

        ArrayList<Integer> inputDataNumerics = new ArrayList<>(asList(
                yRowsSize,
                xColumnsSize,
                devCount,
                managerCount));

        inputDataNumerics.forEach(System.out::println);
        System.out.println();
        gridInputLines.forEach(System.out::println);
        System.out.println();
        devInputLines.forEach(System.out::println);
        System.out.println();
        managerInputLines.forEach(System.out::println);
    }

    public int getYRowsSize() {
        return yRowsSize;
    }

    public int getXColumnsSize() {
        return xColumnsSize;
    }

    public int getDevCount() {
        return devCount;
    }

    public int getManagerCount() {
        return managerCount;
    }

    public ArrayList<ArrayList<String>> getGridInputLines() {
        return gridInputLines;
    }

    public ArrayList<String> getDevInputLines() {
        return devInputLines;
    }

    public ArrayList<String> getManagerInputLines() {
        return managerInputLines;
    }
}
