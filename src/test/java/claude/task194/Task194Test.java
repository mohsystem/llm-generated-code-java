package claude.task194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task194Test {

    private Master master;
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testCase1() {
        master = new Master("acckzz");
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase2() {
        master = new Master("hamada");
        String[] words = {"hamada", "khaled"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase3() {
        master = new Master("abcdef");
        String[] words = {"abcdef", "bbcdef", "abcfef", "abcfeg"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase4() {
        master = new Master("xyzxyz");
        String[] words = {"xyzxyz", "yzxzyz", "zyxzyx", "xyzzyz"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase5() {
        master = new Master("abcdef");
        String[] words = {"abcdef", "bcdefg", "cdefgh", "defghi"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase6() {
        master = new Master("hello");
        String[] words = {"hello", "hallo", "hullo", "hollo"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase7() {
        master = new Master("secret");
        String[] words = {"secret", "secret", "secret", "secret"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase8() {
        master = new Master("example");
        String[] words = {"example", "exempla", "exemlpe", "exemal"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase9() {
        master = new Master("solver");
        String[] words = {"solver", "solvers", "solves", "solverr"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }

    @Test
    void testCase10() {
        master = new Master("worlds");
        String[] words = {"worlds", "wordss", "woldrs", "wolrds"};
        solution.findSecretWord(words, master);
        assertEquals("You guessed the secret word correctly.",
                master.getGuesses() <= 10 ? "You guessed the secret word correctly." : "Either you took too many guesses, or you did not find the secret word.");
    }
}
