package codestral.task168;

public class Task168_MISTRAL_codestral_latest {
    public static String tweakLetters(String word, int[] tweaks) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = (char) (((word.charAt(i) - 'a' + tweaks[i]) % 26) + 'a');
            result.append(c);
        }
        return result.toString();
    }
}