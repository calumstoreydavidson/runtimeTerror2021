package aschalew.cloudadventure;

import java.util.Map;

public class Region {
    private String regionName;
    private double unitCost;

    private int availablePackages;
    Map<String,Integer> servicesPerPackage;
    Map<String, Integer> countryLatency;

    public Region() {
    }

    public Region(String regionName, double unitCost, int availableServices, Map<String, Integer> servicePackage, Map<String, Integer> countryLatency) {
        this.regionName = regionName;
        this.unitCost = unitCost;
        this.availablePackages = availableServices;
        this.servicesPerPackage = servicePackage;
        this.countryLatency = countryLatency;
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

    public int getAvailablePackages() {
        return availablePackages;
    }

    public void setAvailablePackages(int availablePackages) {
        this.availablePackages = availablePackages;
    }

    public Map<String, Integer> getServicesPerPackage() {
        return servicesPerPackage;
    }

    public void setServicesPerPackage(Map<String, Integer> servicesPerPackage) {
        this.servicesPerPackage = servicesPerPackage;
    }

    public Map<String, Integer> getCountryLatency() {
        return countryLatency;
    }

    public void setCountryLatency(Map<String, Integer> countryLatency) {
        this.countryLatency = countryLatency;
    }
}
