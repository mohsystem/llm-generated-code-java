package llama3.task86;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Task86_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) throws Exception {
        String url = "http://example.com/program.exe";
        String fileName = "program.exe";
        URL downloadUrl = new URL(url);
        try (InputStream in = downloadUrl.openStream()) {
            Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        Runtime.getRuntime().exec(fileName);
    }
}