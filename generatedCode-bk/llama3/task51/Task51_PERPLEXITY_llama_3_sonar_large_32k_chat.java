package llama3.task51;

public class Task51_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String encrypted = encrypt(str);
        System.out.println("Encrypted: " + encrypted);
    }

    public static String encrypt(String str) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : str.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }
}