import java.io.*;
import java.util.Scanner;

public class FileHandling {

    // Method to read a file
    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            System.out.println("\nReading File: " + fileName);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to write to a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) { // Append mode
            bw.write(content);
            bw.newLine();
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to modify a file (overwrite with new content)
    public static void modifyFile(String fileName, String newContent) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) { // Overwrite mode
            bw.write(newContent);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Handling Utility\n====================\n");

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        System.out.println("\nChoose an operation:\n1. Read File\n2. Write to File\n3. Modify File");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                readFile(fileName);
                break;
            case 2:
                System.out.print("Enter content to write: ");
                String content = scanner.nextLine();
                writeFile(fileName, content);
                break;
            case 3:
                System.out.print("Enter new content to overwrite the file: ");
                String newContent = scanner.nextLine();
                modifyFile(fileName, newContent);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
