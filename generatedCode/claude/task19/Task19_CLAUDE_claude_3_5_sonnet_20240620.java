package claude.task19;

public class Task19_CLAUDE_claude_3_5_sonnet_20240620 {
    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Task19_CLAUDE_claude_3_5_sonnet_20240620 spinner = new Task19_CLAUDE_claude_3_5_sonnet_20240620();
        System.out.println(spinner.spinWords("Hey fellow warriors"));
        System.out.println(spinner.spinWords("This is a test"));
        System.out.println(spinner.spinWords("This is another test"));
    }
}
