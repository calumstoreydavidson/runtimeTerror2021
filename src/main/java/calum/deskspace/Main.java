package calum.deskspace;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Main {

    private static final ArrayList<String> fileNames = new ArrayList<>(asList(
//            "a_solar.txt",
//            "b_dream.txt",
            "placholder-input.txt"
    ));

    public static void main(String[] args) {
        ProcessIO processIO = new ProcessIO();

        for (String fileName : fileNames) {
            System.out.println("Started processing file: " + fileName);

            String inputFilePath = processIO.getFilePath(processIO.INPUT_DIR, fileName);
            String outputFilePath = processIO.getFilePath(processIO.OUTPUT_DIR, "out_" + fileName);
            ArrayList<String> output = new ArrayList<>(asList("a","b", "c"));

            ArrayList<String> inputLines = processIO.getInputLines(inputFilePath);
            RootDataStructure rootDataStructure = new RootDataStructure(inputLines);

            processIO.writeOutputFile(outputFilePath, output);

            System.out.println("Finished processing file: " + "out_" + fileName);
            System.out.println("--------");
        }
    }
}
