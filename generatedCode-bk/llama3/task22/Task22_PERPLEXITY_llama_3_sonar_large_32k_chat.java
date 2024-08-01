package llama3.task22;

import java.util.ArrayList;
import java.util.List;

public class Task22_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static List<Object> filterList(List<Object> list) {
        List<Object> newList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                newList.add(obj);
            }
        }
        return newList;
    }
}