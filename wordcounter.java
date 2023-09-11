import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the choice

        String text = "";

        switch (choice) {
            case 1:
                System.out.println("Enter your text:");
                text = scanner.nextLine();
                break;

            case 2:
                System.out.print("Enter the path of the file: ");
                String filePath = scanner.nextLine();
                text = FileReaderUtil.readFromFile(filePath);
                break;

            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
                scanner.close();
                return;
        }

        int wordCount = countWords(text);
        System.out.println("Total number of words: " + wordCount);

        scanner.close();
    }

    public static int countWords(String text) {
        String[] words = text.split("[\\s.,!?;:]+");
        return words.length;
    }
}

class FileReaderUtil {
    public static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (java.io.IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
}
