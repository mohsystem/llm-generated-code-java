package claude2.task21;

import java.util.ArrayList;
import java.util.List;

public class Task21_CLAUDE_claude_3_5_sonnet_20240620 {
    public static List<Integer> removeSmallest(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>(numbers);
        int minIndex = 0;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) < result.get(minIndex)) {
                minIndex = i;
            }
        }
        result.remove(minIndex);
        return result;
    }
}
