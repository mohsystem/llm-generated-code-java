package llama3.task101;

import java.io.FileWriter;
import java.io.IOException;

public class Task101_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        throws IOException {
        String filePath = "script.sh";
        String fileContent = "#!/bin/bash
echo 'Hello World'";
        FileWriter writer = new FileWriter(filePath);
        writer.write(fileContent);
        writer.close();
        Runtime.getRuntime().exec("chmod +x " + filePath);
    }
}