package gemini.task22;

import java.util.List;
import java.util.ArrayList;

public class Task22_GEMINI_gemini_1_5_pro_001 {
    public static List<Object> filterList(List<Object> list) {
        List<Object> result = new ArrayList<>();
        for (Object element : list) {
            if (element instanceof Integer) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b")));
        System.out.println(filterList(List.of(1, "a", "b", 0, 15)));
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123)));
    }
}