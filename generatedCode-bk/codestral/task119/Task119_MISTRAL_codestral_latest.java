package codestral.task119;// Java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.csv"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                // Process data here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}