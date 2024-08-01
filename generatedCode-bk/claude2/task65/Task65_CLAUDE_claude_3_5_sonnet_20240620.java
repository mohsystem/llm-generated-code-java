package claude2.task65;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task65_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task65_CLAUDE_claude_3_5_sonnet_20240620 <filename>");
            return;
        }

        String filename = args[0];
        try {
            String content = readFile(filename);
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new Task65_CLAUDE_claude_3_5_sonnet_20240620(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\
");
            }
        }
        return content.toString();
    }
}
