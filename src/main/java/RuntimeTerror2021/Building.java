package RuntimeTerror2021;

public class Building {
    private int x_coord;
    private int y_coord;
    private int latencyWeight;
    private int connectionSpeedWeight;

    public Building(String x_coord, String y_coord, String latencyWeight, String connectionSpeedWeight) {
        this.x_coord = Integer.parseInt(x_coord);
        this.y_coord = Integer.parseInt(y_coord);
        this.latencyWeight = Integer.parseInt(latencyWeight);
        this.connectionSpeedWeight = Integer.parseInt(connectionSpeedWeight);
    }

    public int getX_coord() {
        return x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public int getLatencyWeight() {
        return latencyWeight;
    }

    public int getConnectionSpeedWeight() {
        return connectionSpeedWeight;
    }
}
