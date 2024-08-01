package gtp4o.task56;

import java.util.UUID;

public class Task56_OPENAI_gpt_4o {
    public static void main(String[] args) {
        System.out.println("Java Token: " + generateToken());
    }

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}