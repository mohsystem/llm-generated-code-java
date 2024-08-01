package gtp4o.task158;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task158_OPENAI_gpt_4o {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a command to run: ");
            String command = reader.readLine();
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}