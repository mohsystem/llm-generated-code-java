package llama3.task25;

import java.util.ArrayList;
import java.util.List;

public class Task25_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static  List<String> number(String[] lines) {
//        String[] lines = {"a", "b", "c"};
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            System.out.println();
            result.add((i + 1) + ": " + lines[i]);
        }
        return result;
    }
}