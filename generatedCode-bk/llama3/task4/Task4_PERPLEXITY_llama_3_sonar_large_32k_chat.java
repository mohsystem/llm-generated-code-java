package llama3.task4;

import java.util.HashSet;

public class Task4_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
    }
}