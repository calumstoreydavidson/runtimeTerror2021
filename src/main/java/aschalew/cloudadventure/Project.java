package aschalew.cloudadventure;

import java.util.Map;

public class Project {
    private int penalty;
    private String country;
    Map<String,Integer> unitsNeededForService;


    public Project() {
    }

    public Project(int penalty, String country, Map<String, Integer> unitsNeededForService) {
        this.penalty = penalty;
        this.country = country;
        this.unitsNeededForService = unitsNeededForService;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, Integer> getUnitsNeededForService() {
        return unitsNeededForService;
    }

    public void setUnitsNeededForService(Map<String, Integer> unitsNeededForService) {
        this.unitsNeededForService = unitsNeededForService;
    }
}
