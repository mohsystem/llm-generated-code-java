package gtp4o.task16;

public class Task16_OPENAI_gpt_4o {
    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d")); // false
    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
}