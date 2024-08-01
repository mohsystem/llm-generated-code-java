package gtp4o.task119;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119_OPENAI_gpt_4o {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String line;
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                for (String field : data) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}