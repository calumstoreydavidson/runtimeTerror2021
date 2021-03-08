package aschalew.cloudadventure;

import java.util.List;

public class Provider {
    private String name;
    private List<Region> dataCenters;

    public Provider() {
    }

    public Provider(String name, List<Region> dataCenters) {
        this.name = name;
        this.dataCenters = dataCenters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getDataCenters() {
        return dataCenters;
    }

    public void setDataCenters(List<Region> dataCenters) {
        this.dataCenters = dataCenters;
    }
}
