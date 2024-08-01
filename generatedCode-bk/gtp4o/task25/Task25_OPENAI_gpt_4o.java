package gtp4o.task25;

import java.util.List;
import java.util.ArrayList;

public class Task25_OPENAI_gpt_4o {
    public static List<String> number(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            result.add((i + 1) + ": " + lines.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> lines = List.of("a", "b", "c");
        System.out.println(number(lines));
    }
}