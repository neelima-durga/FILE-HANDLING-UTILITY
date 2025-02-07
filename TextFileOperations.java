import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TextFileOperations {

    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading file: " + filePath);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public static void writeFile(String filePath, String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) { 
            writer.write(content);
            writer.newLine(); 
            System.out.println("Writing to file: " + filePath + (append ? " (appending)" : ""));
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void modifyFile(String filePath, String oldText, String newText) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> modifiedLines = new ArrayList<>();
            for (String line : lines) {
                String modifiedLine = line.replace(oldText, newText); 
                modifiedLines.add(modifiedLine);
            }
            Files.write(Paths.get(filePath), modifiedLines, StandardOpenOption.TRUNCATE_EXISTING); 
            System.out.println("Modifying file: " + filePath);

        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "my_text_file.txt";
        writeFile(filePath, "This is the first line.", false);
        writeFile(filePath, "This is the second line.", true); 
        readFile(filePath);
        modifyFile(filePath, "second", "updated second");
        readFile(filePath);
         List<String> moreLines = List.of("This is line 3", "This is line 4");
          try {
                Files.write(Paths.get(filePath), moreLines, StandardOpenOption.APPEND);
                System.out.println("Added multiple lines");
            } catch (IOException e) {
                System.err.println("Error writing multiple lines: " + e.getMessage());
            }

        readFile(filePath);

    }
}