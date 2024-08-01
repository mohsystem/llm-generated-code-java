package codestral.task21;

import java.util.ArrayList;
import java.util.List;

public class Task21_MISTRAL_codestral_latest {
    public static List<Integer> removeSmallest(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return new ArrayList<>();
        }
        int smallest = numbers.get(0);
        int smallestIndex = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < smallest) {
                smallest = numbers.get(i);
                smallestIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>(numbers);
        result.remove(smallestIndex);
        return result;
    }
}