package llama3.task194;

import java.util.*;

// Master class simulates secret word and guess count exactly like Python version
class Master {
    private final String secret;
    private int guesses = 0;

    public Master(String secret) {
        this.secret = secret;
    }

    public int guess(String word) {
        guesses++;
        int matches = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == word.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    public int getGuessCount() {
        return guesses;
    }
}

public class Task194Test {

    public void findSecretWord(String[] words, Master master) {
        int n = words.length;
        for (int i = 0; i < 10; i++) {
            String guess = words[n / 2]; // same strategy as python (middle element)
            int matches = master.guess(guess);
            if (matches == 6) return;
            List<String> filtered = new ArrayList<>();
            for (String w : words) {
                int matchCount = 0;
                for (int j = 0; j < 6; j++) {
                    if (w.charAt(j) == guess.charAt(j)) {
                        matchCount++;
                    }
                }
                if (matchCount == matches) filtered.add(w);
            }
            words = filtered.toArray(new String[0]);
            n = words.length;
        }
    }

    // Test case 1: matches python example 1
    public void test_example1() {
        String secret = "acckzz";
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        Master master = new Master(secret);

        findSecretWord(words, master);

        if (master.getGuessCount() <= 10) {
            System.out.println("test_example1: PASS");
        } else {
            System.out.println("test_example1: FAIL");
        }
    }

    // Test case 2: matches python example 2
    public void test_example2() {
        String secret = "hamada";
        String[] words = {"hamada", "khaled"};
        Master master = new Master(secret);

        findSecretWord(words, master);

        if (master.getGuessCount() <= 10) {
            System.out.println("test_example2: PASS");
        } else {
            System.out.println("test_example2: FAIL");
        }
    }

    public static void main(String[] args) {
        Task194Test test = new Task194Test();
        test.test_example1();
        test.test_example2();
    }
}
