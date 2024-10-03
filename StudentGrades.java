package Oct_1_Task;

import java.io.*;
import java.util.*;

public class StudentGrades {
    // Function to calculate average of a list of integers
    public static double calculateAverage(List<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "C:\\Files\\grades.txt";
        String outputFile = "C:\\Files\\averages.txt";

        try {
            // File reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            // Read each line from the input file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0]; // First part is the student name

                // The rest are grades, so we parse them into a list of integers
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }

                // Calculate average and write to output file
                double average = calculateAverage(grades);
                writer.write(name + ": " + String.format("%.2f", average));
                writer.newLine(); // Move to the next line in the output file
            }

            // Close the reader and writer to release resources
            reader.close();
            writer.close();

            System.out.println("Average grades have been written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
