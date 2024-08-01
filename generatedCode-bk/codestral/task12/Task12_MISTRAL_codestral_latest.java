package codestral.task12;

public class Task12_MISTRAL_codestral_latest {
    public static String high(String s) {
        String[] words = s.split(" ");
        int maxScore = 0;
        String maxWord = "";
        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                maxWord = word;
            }
        }
        return maxWord;
    }
}