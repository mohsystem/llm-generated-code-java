package llama3.task59;

public class Task59_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            result.append(Character.toUpperCase(s.charAt(i)));
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(s.charAt(j)));
            }
            if (i < s.length() - 1) {
                result.append("-");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(accum("abcd"));
        System.out.println(accum("RqaEzty"));
        System.out.println(accum("cwAt"));
    }
}