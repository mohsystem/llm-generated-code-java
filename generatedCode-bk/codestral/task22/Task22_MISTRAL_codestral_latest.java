package codestral.task22;

import java.util.ArrayList;
import java.util.List;

public class Task22_MISTRAL_codestral_latest {
    public static List<Object> filterList(List<Object> list) {
        List<Object> result = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof Integer) {
                result.add(o);
            }
        }
        return result;
    }
}