package gemini.task16;

public class Task16_GEMINI_gemini_1_5_pro_001 {
  public static boolean solution(String str, String ending) {
    if (str.length() < ending.length()) {
      return false;
    }
    return str.substring(str.length() - ending.length()).equals(ending);
  }
  
  public static void main(String[] args) {
    System.out.println(solution("abc", "bc")); // true
    System.out.println(solution("abc", "d")); // false
  }
}