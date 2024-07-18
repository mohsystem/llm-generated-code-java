package claude.task25;

import java.util.ArrayList;
import java.util.List;

public class Task25_CLAUDE_claude_3_5_sonnet_20240620 {
    public static List<String> number(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            result.add((i + 1) + ": " + lines.get(i));
        }
        return result;
    }
}
