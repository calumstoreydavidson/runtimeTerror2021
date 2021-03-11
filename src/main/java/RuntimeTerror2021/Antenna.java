package RuntimeTerror2021;

public class Antenna {
    private int range;
    private int connectionSpeed;
    private int temp_x_coord;
    private int temp_y_coord;

    public Antenna(String range, String connectionSpeed) {
        this.range = Integer.parseInt(range);
        this.connectionSpeed = Integer.parseInt(connectionSpeed);
    }

    public int getRange() {
        return range;
    }

    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    public int getTemp_x_coord() {
        return temp_x_coord;
    }

    public void setTemp_x_coord(int temp_x_coord) {
        this.temp_x_coord = temp_x_coord;
    }

    public int getTemp_y_coord() {
        return temp_y_coord;
    }

    public void setTemp_y_coord(int temp_y_coord) {
        this.temp_y_coord = temp_y_coord;
    }
}
