package RuntimeTerror2021;

import aschalew.deskspace.Worker;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class RootDataStructure {

    public static final String DELIMITER = " ";

    private InputData inputData;

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();

    public RootDataStructure(ArrayList<String> inputLines) {
        inputData = new InputData(inputLines);


//        splitInputSections(inputLines);
        //        processInputLines(inputLines);
    }

    public RootDataStructure(ArrayList<ArrayList<String>> grid, int otherVar) {
        this.grid = grid;
    }

    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    }

//    private void splitInputSections(ArrayList<String> inputLines) {
//        ArrayList<String> gridInputLines = new ArrayList<>();
//        ArrayList<String> devInputLines = new ArrayList<>();
//        ArrayList<String> managerInputLines = new ArrayList<>();
//
//        //Row 1
//        ArrayList<String> gridAxis = new ArrayList<>(asList(inputLines.get(0).split(DELIMITER)));
//        xColumnsSize = Integer.parseInt(gridAxis.get(0));
//        yRowsSize = Integer.parseInt(gridAxis.get(1));
//
//        int gridSizeDecrementer = yRowsSize;
//        for (int i = 1; i < inputLines.size(); i++) {
//            // do for YRowsSize Rows after row 1
//
//            if (gridSizeDecrementer > 0) {
//                //floor map
////                inputLineGroups.add(new ArrayList<>(asList(inputLines.get(i).split(""))));
//                gridInputLines.add(inputLines.get(i));
//                gridSizeDecrementer--;
//            } else {
//                continue;
//            }
//        }
//
//        devCount = Integer.parseInt(inputLines.get(yRowsSize + 1));
//        int devCountDecrementer = devCount;
//        for (int i = yRowsSize + 3; i < inputLines.size(); i++) {
//            if (devCountDecrementer > 0) {
//                devInputLines.add(inputLines.get(i));
//                devCountDecrementer--;
//            }
//        }
//
//        managerCount = Integer.parseInt(inputLines.get(yRowsSize + devCount + 2));
//        int managerCountDecrementer = managerCount;
//        for (int i = yRowsSize + devCount + 3; i < inputLines.size(); i++) {
//            if (managerCountDecrementer > 0) {
//                managerInputLines.add(inputLines.get(i));
//                managerCountDecrementer--;
//            }
//        }
//
//        inputData = new InputData(
//                yRowsSize,
//                xColumnsSize,
//                devCount,
//                managerCount,
//                gridInputLines,
//                devInputLines,
//                managerInputLines
//        );
//
//        ArrayList<Integer> inputDataNumerics = new ArrayList<>(asList(
//                yRowsSize,
//                xColumnsSize,
//                devCount,
//                managerCount));
//
//        ArrayList<ArrayList<String>> inputLineGroups = new ArrayList<>(asList(
//                gridInputLines,
//                devInputLines,
//                managerInputLines));
//
//        inputDataNumerics.forEach(System.out::println);
//        System.out.println();
//        inputLineGroups.forEach(System.out::println);
//    }

//    // custom code here
//    private void processInputLines(ArrayList<String> inputLines) {
//        //Row 1
//        String[] fields = inputLines.get(0).split(DELIMITER);
//        xColoumnsSize = Integer.parseInt(fields[0]);
//        yRowsSize = Integer.parseInt(fields[1]);
//        int tempCounter = yRowsSize;
//
//        //Row 2 to End
//        for (int i = 1; i < inputLines.size(); i++) {
//
//            // do for YRowsSize Rows after row 1
//            if (tempCounter > 0) {
//                //floor map
//                tempCounter--;
//            }
//
//
//            for (int i = 0; i <; i++) {
//
//            }
//            ArrayList<String> columns = in.split(DELIMITER);
//
//            if ()
//
//                if (line.equals("c1")) {//"criteria1"
//                    int yRowsSize = 7;
//                    int xColoumnsSize = 8;
//                } else if (line.equals("c2")) { // criteria 2
//                    grid.add(new ArrayList<String>());
//                }
//        }
//    }
}
