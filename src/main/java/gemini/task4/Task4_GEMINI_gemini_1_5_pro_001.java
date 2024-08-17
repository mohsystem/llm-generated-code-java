package gemini.task4;

import java.util.HashSet;
import java.util.Set;

class Task4_GEMINI_gemini_1_5_pro_001 {
    public static boolean isIsogram(String str) {
        if (str.length() == 0){
          return true;
        }
        str = str.toLowerCase();
        Set<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }
}