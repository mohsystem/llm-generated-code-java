package gemini.task194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task194Test {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testCase1() {
        String secret = "acckzz";
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase2() {
        String secret = "hamada";
        String[] words = {"hamada", "khaled"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase3() {
        String secret = "abcdef";
        String[] words = {"abcdef", "bbcdef", "abcfef", "abcfeg"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase4() {
        String secret = "xyzxyz";
        String[] words = {"xyzxyz", "yzxzyz", "zyxzyx", "xyzzyz"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase5() {
        String secret = "abcdef";
        String[] words = {"abcdef", "bcdefg", "cdefgh", "defghi"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase6() {
        String secret = "hello";
        String[] words = {"hello", "hallo", "hullo", "hollo"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase7() {
        String secret = "secret";
        String[] words = {"secret", "secrep", "secreq", "secrer"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase8() {
        String secret = "example";
        String[] words = {"example", "exempla", "exemlpe", "exemal"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase9() {
        String secret = "solver";
        String[] words = {"solver", "solvers", "solves", "solverr"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }

    @Test
    void testCase10() {
        String secret = "worlds";
        String[] words = {"worlds", "wordss", "woldrs", "wolrds"};
        TestMaster master = new TestMaster(secret, words);

        solution.findSecretWord(words, master);
        assertEquals(6, master.getLastResult());
    }
}

class TestMaster implements Master {
    private final String secret;
    private final String[] words;
    private int lastResult;
    private int guesses;

    TestMaster(String secret, String[] words) {
        this.secret = secret;
        this.words = words;
        this.lastResult = -1;
        this.guesses = 0;
    }

    @Override
    public int guess(String word) {
        guesses++;
        if (!isInWordList(word)) {
            return -1; // Word is not in the list
        }
        lastResult = calculateMatches(word);
        return lastResult;
    }

    private boolean isInWordList(String word) {
        for (String w : words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private int calculateMatches(String word) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (secret.charAt(i) == word.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    public int getLastResult() {
        return lastResult;
    }
}
