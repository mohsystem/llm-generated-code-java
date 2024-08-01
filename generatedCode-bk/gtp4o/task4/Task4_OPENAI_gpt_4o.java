package gtp4o.task4;

import java.util.HashSet;

public class Task4_OPENAI_gpt_4o {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
    }
}