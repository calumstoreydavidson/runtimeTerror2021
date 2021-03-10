package RuntimeTerror2021;

import java.util.ArrayList;

public class RootDataStructure {

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    private int yRowsSize;
    private int xColoumnsSize;

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
        if (line.equals("c1")) {//"criteria1"
            int yRowsSize = 7;
            int xColoumnsSize = 8;
        } else if (line.equals("c2")) { // criteria 2
            grid.add(new ArrayList<String>());
        }
    }
}
