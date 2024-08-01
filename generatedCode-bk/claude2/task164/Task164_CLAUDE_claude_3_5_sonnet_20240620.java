package claude2.task164;

import java.util.*;

public class Task164_CLAUDE_claude_3_5_sonnet_20240620 {
    public static List<String> lastNameLenSort(List<String> names) {
        names.sort((a, b) -> {
            String[] aParts = a.split(" ");
            String[] bParts = b.split(" ");
            String aLastName = aParts[aParts.length - 1];
            String bLastName = bParts[bParts.length - 1];
            
            if (aLastName.length() != bLastName.length()) {
                return Integer.compare(aLastName.length(), bLastName.length());
            }
            return aLastName.compareTo(bLastName);
        });
        return names;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
            "Jennifer Figueroa",
            "Heather Mcgee",
            "Amanda Schwartz",
            "Nicole Yoder",
            "Melissa Hoffman"
        );
        System.out.println(lastNameLenSort(names));
    }
}
