package codestral.task30;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task30_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
    }

    public static String longest(String s1, String s2) {
        return Arrays.stream(s1.concat(s2).split(""))
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }
}