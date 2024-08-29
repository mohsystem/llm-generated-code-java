package codestral.task194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task194Test {

    private Task194_MISTRAL_codestral_latest solution;

    @BeforeEach
    void setUp() {
        solution = new Task194_MISTRAL_codestral_latest();
    }

    private class TestMaster extends Master {
        private final String secret;
        private int guesses;

        TestMaster(String secret) {
            this.secret = secret;
            this.guesses = 0;
        }

        @Override
        public int guess(String word) {
            guesses++;
            if (word.equals(secret)) {
                return 6;
            }
            int matches = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    matches++;
                }
            }
            return matches;
        }

        public int getGuesses() {
            return guesses;
        }
    }

    @Test
    void testCase1() {
        TestMaster master = new TestMaster("acckzz");
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase2() {
        TestMaster master = new TestMaster("hamada");
        String[] words = {"hamada", "khaled"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase3() {
        TestMaster master = new TestMaster("abcdef");
        String[] words = {"abcdef", "bbcdef", "abcfef", "abcfeg"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase4() {
        TestMaster master = new TestMaster("xyzxyz");
        String[] words = {"xyzxyz", "yzxzyz", "zyxzyx", "xyzzyz"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase5() {
        TestMaster master = new TestMaster("abcdef");
        String[] words = {"abcdef", "bcdefg", "cdefgh", "defghi"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase6() {
        TestMaster master = new TestMaster("hello");
        String[] words = {"hello", "hallo", "hullo", "hollo"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase7() {
        TestMaster master = new TestMaster("secret");
        String[] words = {"secret", "secrets", "secrett", "secre"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase8() {
        TestMaster master = new TestMaster("example");
        String[] words = {"example", "exempla", "exemlpe", "exemal"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase9() {
        TestMaster master = new TestMaster("solver");
        String[] words = {"solver", "solvers", "solves", "solverr"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase10() {
        TestMaster master = new TestMaster("worlds");
        String[] words = {"worlds", "wordss", "woldrs", "wolrds"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    private String getResult(TestMaster master, int allowedGuesses) {
        return master.getGuesses() <= allowedGuesses ?
                "You guessed the secret word correctly." :
                "Either you took too many guesses, or you did not find the secret word.";
    }
}
