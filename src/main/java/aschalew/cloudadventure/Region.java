package aschalew.cloudadventure;

import java.util.Map;

public class Region {
    private String regionName;
    private double unitCost;
    private int availableServices;
    Map<String,Integer> servicePackage;
    Map<String, Integer> countryLatency;

    public Region() {
    }

    public Region(String regionName, double unitCost, int availableServices, Map<String, Integer> servicePackage, Map<String, Integer> countryLatency) {
        this.regionName = regionName;
        this.unitCost = unitCost;
        this.availableServices = availableServices;
        this.servicePackage = servicePackage;
        this.countryLatency = countryLatency;
    }

    public int getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(int availableServices) {
        this.availableServices = availableServices;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public Map<String, Integer> getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(Map<String, Integer> servicePackage) {
        this.servicePackage = servicePackage;
    }

    public Map<String, Integer> getCountryLatency() {
        return countryLatency;
    }

    public void setCountryLatency(Map<String, Integer> countryLatency) {
        this.countryLatency = countryLatency;
    }
}
