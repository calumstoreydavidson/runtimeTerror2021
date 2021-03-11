package calum.deskspace;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessIO {

    public final String INPUT_DIR = "src/main/resources/runtimeTerror2021/input/";
    public final String OUTPUT_DIR = "src/main/resources/runtimeTerror2021/output/";
    public static final String DELIMITER = " ";

    public ArrayList<String> getInputLines(String filePath) {
        ArrayList<String> inputLines = new ArrayList<>();
        readInputFile(filePath, inputLines);
        return inputLines;
    }

    private void readInputFile(String filePath, ArrayList<String> inputLines) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                inputLines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFilePath(String dir, String fileName) {
        return (dir + fileName);
    }

    public void writeOutputFile(String filePath, ArrayList<String> output) {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String line : output) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
