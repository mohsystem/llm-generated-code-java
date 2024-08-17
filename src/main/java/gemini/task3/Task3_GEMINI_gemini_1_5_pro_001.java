package gemini.task3;

import java.util.HashSet;
import java.util.Set;

class Task3_GEMINI_gemini_1_5_pro_001 {
    public static boolean isPangram(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                seen.add(c);
            }
        }
        return seen.size() == 26;
    }
}