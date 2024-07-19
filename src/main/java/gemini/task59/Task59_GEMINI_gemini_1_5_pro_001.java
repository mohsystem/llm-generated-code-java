package gemini.task59;

public class Task59_GEMINI_gemini_1_5_pro_001 {

    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()) {
            if (i > 0) sb.append('-');
            sb.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) sb.append(Character.toLowerCase(c));
            i++;
        }
        return sb.toString();
  }
    public static void main(String[] args) {
        System.out.println(accum("abcd"));
        System.out.println(accum("RqaEzty"));
        System.out.println(accum("cwAt"));
    }
}