import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Operation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath;

        System.out.print("Enter file path: ");
        filePath = scanner.nextLine();
        try {
            Files.createFile(Paths.get(filePath));
            System.out.println("File created: " + filePath);
        } catch (IOException e) {
            if (!e.getMessage().contains("File exists")) {
               System.err.println("Error creating file (may already exist): " + e.getMessage());
            }
        }


        int choice;
        do {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Read File");
            System.out.println("2. Write to File (Overwrite)");
            System.out.println("3. Append to File");
            System.out.println("4. Modify File (Replace Text)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
            }
        } while (choice != 5);

        scanner.close();
    }
}
