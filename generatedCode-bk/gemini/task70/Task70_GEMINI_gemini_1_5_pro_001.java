package gemini.task70;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task70_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Please provide the file path as a command line argument.");
            System.exit(1);
        }
        String filePath = args[0];
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.print(content);
    }
}