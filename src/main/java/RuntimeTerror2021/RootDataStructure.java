package RuntimeTerror2021;

import java.util.ArrayList;

public class RootDataStructure {

    public static final String DELIMITER = " ";
    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    private int yRowsSize;
    private int xColoumnsSize;
    private int lineCounter = 0;


    public RootDataStructure(ArrayList<String> inputLines) {
        inputLines.forEach(this::processInputLine);
    }

    public RootDataStructure(ArrayList<ArrayList<String>> grid, int otherVar) {
        this.grid = grid;
    }

    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    }

    // custom code here
    private void processInputLine(String line) {
        String[] fields = line.split(DELIMITER);

        if (line.equals("c1")) {//"criteria1"
            int yRowsSize = 7;
            int xColoumnsSize = 8;
        } else if (line.equals("c2")) { // criteria 2
            grid.add(new ArrayList<String>());
        }
    }
}
