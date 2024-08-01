package llama3.task60;

public class Task60_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static String expandedForm(int num) {
        String str = String.valueOf(num);
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                result += str.charAt(i);
                for (int j = i + 1; j < str.length(); j++) {
                    result += "0";
                }
                if (i < str.length() - 1) {
                    result += " + ";
                }
            }
        }
        return result;
    }
}