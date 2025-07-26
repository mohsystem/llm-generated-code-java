package llama3.task101;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task101_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) throws IOException {
        File file = new File("script.sh");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("#!/bin/bash\necho 'Hello World'");
        }

        // Check OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // On Windows: use Java API
            file.setExecutable(true);
        } else {
            // On Unix/Linux/macOS: use chmod
            try {
                Runtime.getRuntime().exec("chmod +x script.sh");
            } catch (IOException e) {
                System.err.println("chmod failed: " + e.getMessage());
            }
        }
    }
}
