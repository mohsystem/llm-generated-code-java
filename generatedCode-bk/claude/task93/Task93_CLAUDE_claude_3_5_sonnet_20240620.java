package claude.task93;

import java.io.*;
import java.util.*;

public class Task93_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        String fileName = "input.txt";
        TreeMap<String, String> sortedMap = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    sortedMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
