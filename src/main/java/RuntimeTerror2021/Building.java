package RuntimeTerror2021;

import java.util.ArrayList;

public class Building {
    private Coord coord;
    private int latencyWeight;
    private int connectionSpeedWeight;

    public Building(String x_coord, String y_coord, String latencyWeight, String connectionSpeedWeight) {
        this.coord = new Coord(Integer.parseInt(y_coord, Integer.parseInt(x_coord));
        this.latencyWeight = Integer.parseInt(latencyWeight);
        this.connectionSpeedWeight = Integer.parseInt(connectionSpeedWeight);
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
