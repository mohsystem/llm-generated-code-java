package gemini.task158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter OS command: ");
        String command = reader.readLine();
        Runtime.getRuntime().exec(command);
    }
}