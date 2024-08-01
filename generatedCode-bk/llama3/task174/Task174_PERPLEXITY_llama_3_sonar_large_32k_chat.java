package llama3.task174;

public class Task174_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(rev_s.substring(i))) {
                return rev_s.substring(0, i) + s;
            }
        }
        return "";
    }
}