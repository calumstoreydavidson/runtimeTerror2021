package RuntimeTerror2021;

import java.util.ArrayList;

import static RuntimeTerror2021.RootDataStructure.DELIMITER;
import static java.util.Arrays.asList;

public class InputData {

    private int yRowsSize;
    private int xColumnsSize;
    private int devCount;
    private int managerCount;

    ArrayList<ArrayList<String>> gridInputLines;
    ArrayList<String> devInputLines;
    ArrayList<String> managerInputLines;

//    public InputData(int yRowsSize, int xColumnsSize, int devCount, int managerCount, ArrayList<String> gridInputLines,
//                     ArrayList<String> devInputLines, ArrayList<String> managerInputLines) {
//        this.yRowsSize = yRowsSize;
//        this.xColumnsSize = xColumnsSize;
//        this.devCount = devCount;
//        this.managerCount = managerCount;
//        this.gridInputLines = gridInputLines;
//        this.devInputLines = devInputLines;
//        this.managerInputLines = managerInputLines;
//    }

    public InputData(ArrayList<String> inputLines){
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
            // do for YRowsSize Rows after row 1

            if (gridSizeDecrementer > 0) {
                //floor map
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
        for (int i = yRowsSize + 3; i < inputLines.size(); i++) {
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

        ArrayList<ArrayList<String>> inputLineGroups = new ArrayList<>(asList(
                devInputLines,
                managerInputLines));

        inputDataNumerics.forEach(System.out::println);
        System.out.println();
        gridInputLines.forEach(System.out::println);
        System.out.println();
        inputLineGroups.forEach(System.out::println);
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
