package RuntimeTerror2021;

import java.util.ArrayList;

public class Building {
    private Coord coord;
    private int latencyWeight;
    private int connectionSpeedWeight;

    public Building(String x_coord, String y_coord, String latencyWeight, String connectionSpeedWeight) {
        this.coord = new Coord(Integer.parseInt(x_coord), Integer.parseInt(y_coord));
        this.latencyWeight = Integer.parseInt(latencyWeight);
        this.connectionSpeedWeight = Integer.parseInt(connectionSpeedWeight);
    }

    public ArrayList<Coord> getPointsInRange(int range, int H_yRowsSize, int W_xColumnsSize) {
        ArrayList<Coord> pointsInRange = new ArrayList<>();

        //TODO inefficient!!!!!
        for (int i = 0; i < W_xColumnsSize; i++) {
            for (int j = 0; j < H_yRowsSize; j++) {
                //manhattan distance?
                if (inRange(range, i, j)) {
                    pointsInRange.add(new Coord(i, j));
                }
            }
        }

        return pointsInRange;
    }

    private boolean inRange(int range, int x, int y) {
        return UtilMethods.getAbsDiff(coord.x_col, x) <= range && UtilMethods.getAbsDiff(coord.y_row, y) <= range;
    }

    public int getX_coord() {
        return coord.getX_col();
    }

    public int getY_coord() {
        return coord.getY_row();
    }

    public int getLatencyWeight() {
        return latencyWeight;
    }

    public int getConnectionSpeedWeight() {
        return connectionSpeedWeight;
    }
}
