package llama3.task42;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task42_PERPLEXITY_llama_3_sonar_large_32k_chat {
    private Map<String, String> users;

    public Task42_PERPLEXITY_llama_3_sonar_large_32k_chat() {
        this.users = new HashMap<>();
        this.users.put("admin", "password123");
        this.users.put("user", "password456");
    }

    public boolean authenticate(String username, String password) {
        return this.users.getOrDefault(username, "").equals(password);
    }

    public static void main(String[] args) {
        Task42_PERPLEXITY_llama_3_sonar_large_32k_chat auth = new Task42_PERPLEXITY_llama_3_sonar_large_32k_chat();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (auth.authenticate(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}