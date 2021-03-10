package RuntimeTerror2021;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class RootDataStructure {

    public static final String DELIMITER = " ";

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    private ArrayList<> devs = new ArrayList<>();

    private int yRowsSize;
    private int xColoumnsSize;
    private int lineCounter = 0;

    public RootDataStructure(ArrayList<String> inputLines) {
        splitInputSections(inputLines);
        //        processInputLines(inputLines);
    }

    public RootDataStructure(ArrayList<ArrayList<String>> grid, int otherVar) {
        this.grid = grid;
    }

    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    }

    private void splitInputSections(ArrayList<String> inputLines) {
        ArrayList<ArrayList<String>> inputLineGroups = new ArrayList<ArrayList<String>>();
        //Row 1
        String[] fields = inputLines.get(0).split(DELIMITER);
        xColoumnsSize = Integer.parseInt(fields[0]);
        yRowsSize = Integer.parseInt(fields[1]);
        int devCount;

        int gridSizeDecrementer = yRowsSize;
        for (int i = 1; i < inputLines.size(); i++) {
            // do for YRowsSize Rows after row 1

            if (gridSizeDecrementer > 0) {
                //floor map
                grid.add(new ArrayList<>(asList(inputLines.get(i).split(""))));
                gridSizeDecrementer--;
            } else {
                continue;
            }
        }

        devCount = Integer.parseInt(inputLines.get(yRowsSize + 2));
        int devCountDecrementer = devCount;
        for (int i = yRowsSize + 3; i < inputLines.size(); i++) {
            if (devCountDecrementer > 0) {
                
                devCountDecrementer--;
            }
        }


        grid.forEach(System.out::println);
        System.out.println(devCount);
    }

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
