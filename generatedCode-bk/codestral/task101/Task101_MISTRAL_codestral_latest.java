package codestral.task101;

import java.io.File;
import java.io.IOException;

public class Task101_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        try {
            File file = new File("script.sh");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                if (file.setExecutable(true)) {
                    System.out.println("File is now executable");
                } else {
                    System.out.println("Failed to make file executable");
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}