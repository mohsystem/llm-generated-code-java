package claude.task194;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Mock Master class
class Master {
    private String secret;

    public Master(String secret) {
        this.secret = secret;
    }

    public int guess(String word) {
        if (word.length() != 6) return -1;
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}

class Solution {
    public void findSecretWord(String[] words, Master master) {
        for (int i = 0, n = 0; i < 10 && n < 6; ++i) {
            String guess = words[new Random().nextInt(words.length)];
            n = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for (String w : words)
                if (match(guess, w) == n)
                    candidates.add(w);
            words = candidates.toArray(new String[0]);
        }
    }

    private int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i))
                matches++;
        return matches;
    }
}
