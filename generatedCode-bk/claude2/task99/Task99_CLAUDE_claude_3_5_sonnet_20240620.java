package claude2.task99;

import java.io.*;
import java.util.regex.*;

public class Task99_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String regex = "^\\\\d+.*\\\\.$";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
