package llama3.task127;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task127_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        String srcDir = "/path/to/source/directory";
        String srcFile = "file.txt";
        String dstDir = "/path/to/temporary/directory";
        copyFile(srcDir, srcFile, dstDir);
    }

    public static void copyFile(String srcDir, String srcFile, String dstDir) {
        try {
            Path srcPath = Paths.get(srcDir, srcFile);
            Path dstPath = Paths.get(dstDir, srcFile);
            Files.copy(srcPath, dstPath);
            System.out.println("File " + srcFile + " copied successfully to " + dstDir);
        } catch (IOException e) {
            if (e instanceof java.nio.file.NoSuchFileException) {
                System.out.println("Error: File " + srcFile + " not found in " + srcDir);
            } else if (e instanceof java.nio.file.AccessDeniedException) {
                System.out.println("Error: Permission denied to read file " + srcFile + " in " + srcDir + " or write to " + dstDir);
            } else {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}