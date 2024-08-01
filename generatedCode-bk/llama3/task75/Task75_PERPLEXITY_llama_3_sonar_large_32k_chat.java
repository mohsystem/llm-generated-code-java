package llama3.task75;

import java.lang.Process;

public class Task75_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task75_PERPLEXITY_llama_3_sonar_large_32k_chat <PID>");
            return;
        }
        try {
            Process process = Runtime.getRuntime().exec("taskkill /pid " + args[0]);
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}