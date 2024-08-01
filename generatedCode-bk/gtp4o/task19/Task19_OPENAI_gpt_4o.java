package gtp4o.task19;

// Java
public class Task19_OPENAI_gpt_4o {
    public static void main(String[] args) {
        String input = "Hey fellow warriors";
        System.out.println(reverseWords(input));
    }
    
    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}