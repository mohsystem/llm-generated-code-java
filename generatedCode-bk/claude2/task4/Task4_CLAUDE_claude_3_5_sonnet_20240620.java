package claude2.task4;

import java.util.HashSet;
import java.util.Set;

public class Task4_CLAUDE_claude_3_5_sonnet_20240620 {
    public static boolean isIsogram(String str) {
        Set<Character> letters = new HashSet<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (!letters.add(c)) {
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
