package aschalew.cloudadventure;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CloudAdventure {
    private int noOfProviders = 0;
    private int noOfServices = 0;
    private int nrOfCountries = 0;
    private int noOfProjects = 0;
    private String[] services;
    private String[] countries;
    private List<Provider> providers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private Map<String,List<Region>> countryDatacenters;
    private Map<String, List<String>> countryRegionsMap = new HashMap<>();
    //private List<>

    public static void main(String[] args) {

        String filePath = "F:\\NeonEE\\workspace\\test\\src\\src\\main\\resources\\input\\cloudtest.txt";

        CloudAdventure ca = new CloudAdventure();
        // read file and set up data structure
        // create Country regions map
        ca.createCountryRegionsMap();
        ca.readFileAndSetupFloor(filePath);
        // country - datacenter map
        ca.mapCountryToDatacenter();
        // process ths data
        ca.processProjects();
        // print the out come
        System.out.println("");

    }

    private void processProjects() {
        // choose the provider and region based on project country
        // choose provider country/region based on the latency figure
        for (Project project:projects){
            for (Provider provider:providers){
                if (countryDatacenters.containsKey(project.getCountry())){
                    List<Region> regions = countryDatacenters.get(project.getCountry());
                    for (Region region:regions){
                        // calculate average latency
                        double apl = calculateAverageLatency(region, project);
                        // calculate availability index
                        double oai = calculateAvailabilityIndex(region, project);
                        // calculate SLA penalty
                        double slaPenalty = calculateSlaPenalty(region, project);
                        // calculate total project cost
                        double tpc = calculateTotalProjectCost(region, project);
                    }

                }
            }
        }
    }

    private double calculateTotalProjectCost(Region region, Project project) {

        /*
            𝑇𝑝 =(A𝑣𝑒𝑟𝑎𝑔𝑒 𝑝𝑟𝑜𝑗𝑒𝑐𝑡 𝑙𝑎𝑡𝑒𝑛𝑐𝑦/O𝑣𝑒𝑟𝑎𝑙𝑙 𝑎𝑣𝑎𝑖𝑙𝑎𝑏𝑖𝑙𝑖𝑡𝑦 𝑖𝑛𝑑𝑒𝑥)× (𝑡𝑜𝑡𝑎𝑙 𝑜𝑝𝑒𝑟𝑎𝑡𝑖𝑜𝑛𝑎𝑙 𝑝𝑟𝑜𝑗𝑒𝑐𝑡 𝑐𝑜𝑠𝑡)
         */
        return 0.0;
    }

    private double calculateSlaPenalty(Region region, Project project) {
        /*
            we call ‘𝐹𝑠 ’ the fine related to the service
            𝐹𝑠 = (𝑏𝑎𝑠𝑒 𝑝𝑟𝑜𝑗𝑒𝑐𝑡 𝑝𝑒𝑛𝑎𝑙𝑡𝑦) ×(𝑢𝑛𝑖𝑡𝑠 𝑛𝑒𝑒𝑑𝑒𝑑) − 𝑚𝑖𝑛(𝑢𝑛𝑖𝑡𝑠 𝑛𝑒𝑒𝑑𝑒𝑑, 𝑠𝑢𝑚 𝑜𝑓 𝑎𝑙𝑙𝑜𝑐𝑎𝑡𝑒𝑑 𝑢𝑛𝑖𝑡𝑠)/(𝑢𝑛𝑖𝑡𝑠 𝑛𝑒𝑒𝑑𝑒𝑑)

            When the units needed for a service are 0, we assume 𝐹𝑠 = 0.
            We define 𝐹𝑝 as the average all of the service fines 𝐹𝑠 of the project.

            Your final score 𝑆 will be:


            𝑆= Σp10 po. of 9/𝑇𝑝 + 𝐹𝑝
         */
        return 0.0;
    }

    private double calculateAvailabilityIndex(Region region, Project project) {

        /*
            we call ‘𝑞𝑖 ’ the number of units bought from a given region of a certain provider
            availability index ′𝑎𝑠 ′ for a given service type ‘s’
              𝑎𝑠 =sq of(Σ 𝑞𝑖 )/Σ(sq. of 𝑞𝑖)

              When no resources have been taken from a service type (meaning both Σ 𝑞𝑖 = 0 and Σ(𝑞𝑖2) = 0), then we assume 𝑎𝑠 = 0.

              OAI = avg of 𝑎𝑠
         */
        // 255000 Italy 20 0 555
        /*
            avg(
                [(16 + 9 + 40)^2 /(16^2 + 9^2 +40^2)];
                [(16 + 90 + 100)^2 /(16^2 + 90^2+ 100^2)];
                [(16 + 45 + 500)^2 /(16^2 + 45^2+ 500^2)]
               )
         */

        return 0.0;
    }
    /*
            Output
            For each project, output a line describing how many packages you intend to buy from each provider. Assume the
            order of lines in the output file matches the order of the projects in the input file – i.e. the first line in the output file
            satisfies the first program in the input file. For each service needed, you can opt to buy the required number of
            service units made up of packages from different providers.
            Each line is composed of a sequence of declarations, each one related to a single provider. Each declaration is
            built from the following information, separated by a single ASCII whitespace: the zero-based index of the provider
            in the input file, the zero-based index of the region inside the list of that provider, the number of packages you
            intend to acquire from that provider.
            You can allocate more service units than the one requested by each project. If you don’t intend to buy any
            packages from a particular provider and region, omit that declaration completely. If you intend to leave a project
            completely unsatisfied, output an empty line for it.
            The output file must be a single, ASCII encoded text file.
            [the zero-based index of the provider in the input file][the zero-based index of the region inside the list of that provider][the number of packages you
            intend to acquire from that provider]
            Scoring
            0 0 60 1 0 1 1 1 8 2 0 1 2 1 10
            0 1 3 0 3 1 1 0 5
            0 1 2 0 3 9 2 0 1
            2 0 4 2 1 4
            0 1 95 0 2 10 1 0 69 1 1 17 2 0 24 2 1 1 2 2 50
     */
    private double calculateAverageLatency(Region region, Project project) {
        // Average project latency = Σ𝑟𝐿𝑟×𝑈𝑟/Σ𝑟𝑈𝑟
        /*

            1 package from Amazon - Seattle containing 1 unit of cpu and 2 units of ram
            3 package from Microsoft - Redmond containing 5 units of cpu and 3 units of ram

            And there are the following latencies:
            Amazon-Italy 125
            Microsoft-Italy 130

            The Average Project Latency(APL) is:
            numerator: 125* [1*(1+2)] + 130*[3*(5+3)]
            denominator: 1*(1+2) + 3*(5+3)
            if 𝑈𝑟 == 0, then APL= 0
         */
        return 0.0;
    }

    private void createCountryRegionsMap() {
        List<String> regionNames  = new ArrayList<>();
        regionNames.add("Milan");
        countryRegionsMap.put("Italy", regionNames);
        regionNames  = new ArrayList<>();
        regionNames.add("Madrid");
        countryRegionsMap.put("Spain", regionNames);
        regionNames  = new ArrayList<>();
        regionNames.add("Moscow");
        countryRegionsMap.put("Russia", regionNames);
        regionNames  = new ArrayList<>();
        regionNames.add("Dublin");
        countryRegionsMap.put("Ireland", regionNames);
        regionNames  = new ArrayList<>();
        regionNames.add("Berlin");
        countryRegionsMap.put("Germany", regionNames);
        regionNames  = new ArrayList<>();
        regionNames.add("Sidney");
        countryRegionsMap.put("Australia", regionNames);
        //regionNames.clear();
    }

    private void mapCountryToDatacenter() {
        countryDatacenters = new HashMap<>();
        for (String country:countries) {
            for (Provider provider : providers) {
                List<Region>regions = new ArrayList<>();
                for (Region region:provider.getDataCenters()){
                    if (isThisRegionInCountry(region.getRegionName(), country)){
                        regions.add(region);
                    }
                }
                if (regions.size() > 0) {
                    countryDatacenters.put(country, regions);
                }

            }
        }
    }

    private boolean isThisRegionInCountry(String regionName, String country) {
        List<String> dataCenters = countryRegionsMap.get(country);
        if (dataCenters != null && dataCenters.contains(regionName)){
            return true;
        }
        return false;
    }

    Provider chooseAvailableProviderForLeastLatency(String County, String requiredService){
        int services = 0;
        for (Provider provider: providers){
            for (Region region : provider.getDataCenters().toArray(new Region[0])){
                /*if (region.getServicePackage().get(service) > services){
                    services = region.getServicePackage().get(service)
                }*/
            }
        }
        return null;
    }
    private void readFileAndSetupFloor(String filePath) {


        Scanner scanner;
        try{
            scanner = new Scanner(new File(filePath));
            int counter = 0;

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");
                if (counter == 0){
                    noOfProviders = Integer.valueOf(fields[0]);
                    noOfServices = Integer.valueOf(fields[1]);
                    nrOfCountries = Integer.valueOf(fields[2]);
                    noOfProjects = Integer.valueOf(fields[3]);
                    counter++;
                    continue;
                }
                if (counter == 1){
                    services = new String[noOfServices];
                    for (int i = 0; i < fields.length; i++){
                        services[i] = fields[i];
                    }
                    counter++;
                    continue;
                }
                if (counter == 2){
                    countries = new String[nrOfCountries];
                    for (int i = 0; i < fields.length; i++){
                        countries[i] = fields[i];
                    }
                    counter++;
                    continue;
                }
                if (fields.length == 2){
                    Provider provider = new Provider();
                    provider.setName(fields[0]);
                    List<Region> regions = new ArrayList<>();


                    for (int j = 0; j < Integer.valueOf(fields[1]); j++){
                        Region region = new Region();
                        line = scanner.nextLine();
                        region.setRegionName(line);
                        line = scanner.nextLine();
                        String[] regionFields = line.split(" ");
                        Map<String,Integer> serviceMap = new HashMap<>();
                        for (int m = 0; m < regionFields.length; m++) {
                            if(m == 0){
                                region.setAvailableServices(Integer.valueOf(regionFields[m]));
                            } else if (m == 1) {
                                region.setUnitCost(Double.valueOf(regionFields[m]));
                            } else {
                                serviceMap.put(services[m - 2], Integer.valueOf(regionFields[m]));
                            }
                        }
                        region.setServicePackage(serviceMap);
                        line = scanner.nextLine();
                        regionFields = line.split(" ");
                        Map<String, Integer> latencyMap = new HashMap<>();
                        for (int r = 0; r < regionFields.length; r++){
                            latencyMap.put(countries[r], Integer.valueOf(regionFields[r]));
                        }
                        region.setCountryLatency(latencyMap);
                        regions.add(region);
                        provider.setDataCenters(regions);
                    }
                    providers.add(provider);


                }

                if (isNumeric(fields[0] ) && !isNumeric(fields[1]) && fields[0].length() > 5){
                    Project project = new Project();
                    Map<String, Integer> serviceUnits = new HashMap<>();
                    for (int n = 0; n < fields.length; n++) {
                        if (n == 0) {
                            project.setPenalty(Integer.valueOf(fields[0]));
                        } else if (n == 1) {
                            project.setCountry(fields[1]);
                        } else {
                            serviceUnits.put(services[n - 2], Integer.valueOf(fields[n]));
                        }
                    }
                    project.setUnitsNeededForService(serviceUnits);
                    projects.add(project);
                }


            }
        } catch (IOException ex){

        }
    }

    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }


}
