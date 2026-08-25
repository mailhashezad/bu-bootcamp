import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores(filename); // Step 1: read scores from file
        ArrayList<Integer> testscores = new ArrayList<>();
        testscores.add(23);
        testscores.add(75);
        testscores.add(99);
        testscores.add(59);
        testscores.add(80);
        calculateAverage(testscores); // appling the function on test data

        double avg = calculateAverage(scores); // calculating the average here
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        System.out.println("=== Grade Analysis Report ===");

        for (int n : scores) {
            if (n > highest) {
                highest = n;

            }
            if (n < lowest) {
                lowest = n;

            }

        }
        System.out.println("Average score: " + avg); // Step 2: calculate statistics
        System.out.println("highest score: " + highest);

        System.out.println("lowest score: " + lowest);
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int n : scores) {
            if (n >= 90) {
                countA++;
            } else if (n >= 80 && n <= 89) {
                countB++;
            } else if (n >= 70 && n <= 79) {
                countC++;
            } else if (n >= 60 && n <= 69) {
                countD++;
            } else {
                countF++;
            }
        }

        System.out.println("Grade Distribution:");
        System.out.println("A (90-100):  " + countA);
        System.out.println("B (80-89):  " + countB);
        System.out.println("C (70-79):  " + countC);
        System.out.println("D (60-69):  " + countD);
        System.out.println("F (below 60):  " + countF);

        writeReport(scores, avg, highest, lowest, countA, countB, countC, countD, countF, filename); // Step 3: write
                                                                                                     // and print report
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>(); // defining the arry list here for the scores making a variable
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String trimmed = line.trim();
                if (trimmed.isEmpty()) {
                    continue;
                }
                try {
                    int n = Integer.parseInt(trimmed);
                    scores.add(n);

                } catch (NumberFormatException e) {
                    System.out.println("warning skipping an in valid line " + trimmed);
                }

            }
        } catch (IOException e) {
            System.out.println("File not found " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int n : scores) {
            sum += n;
        }

        return sum / scores.size();// your code here
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int highest, int lowest, int countA, int countB, int countC, int countD, int countF,
            String outputFile) {

        outputFile = "report.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("=== Grade Analysis Report ==="));
            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", highest));
            writer.write(String.format("lowest score: %d%n", lowest));
            writer.newLine();
            writer.newLine();
            writer.write(String.format("Grade distribution:"));
            writer.newLine();

            writer.write(String.format("A (90-100):  " + countA));
            writer.newLine();
            writer.write(String.format("B (80-89):  " + countB));
            writer.newLine();
            writer.write(String.format("C (70-79):  " + countC));
            writer.newLine();
            writer.write(String.format("D (60-69):  " + countD));
            writer.newLine();
            writer.write(String.format("F (below 60):  " + countF));

        } catch (IOException e) {
            System.err.println("File not found " + e);
        }
        System.out.println("\n");
        System.out.println("Report data:");

        try (BufferedReader readerr = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = readerr.readLine()) != null) {
                System.out.println(line);

            }
        } catch (Exception e) {
            System.out.println("File not found " + e);
            
        }
    }
}
