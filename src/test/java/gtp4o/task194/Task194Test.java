package gtp4o.task194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task194Test {

    private Task194_OPENAI_gpt_4o solution;

    @BeforeEach
    void setUp() {
        solution = new Task194_OPENAI_gpt_4o();
    }

    @Test
    void testCase1() {
        String secret = "acckzz";
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase2() {
        String secret = "hamada";
        String[] words = {"hamada", "khaled"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase3() {
        String secret = "abcdef";
        String[] words = {"abcdef", "bbcdef", "abcfef", "abcfeg"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase4() {
        String secret = "xyzxyz";
        String[] words = {"xyzxyz", "yzxzyz", "zyxzyx", "xyzzyz"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase5() {
        String secret = "abcdef";
        String[] words = {"abcdef", "bcdefg", "cdefgh", "defghi"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase6() {
        String secret = "hello";
        String[] words = {"hello", "hallo", "hullo", "hollo"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase7() {
        String secret = "secret";
        String[] words = {"secret", "secrep", "secreq", "secrer"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase8() {
        String secret = "example";
        String[] words = {"example", "exempla", "exemlpe", "exemal"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase9() {
        String secret = "solver";
        String[] words = {"solver", "solvers", "solves", "solverr"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase10() {
        String secret = "worlds";
        String[] words = {"worlds", "wordss", "woldrs", "wolrds"};
        int allowedGuesses = 10;
        Master master = new Master(secret);

        solution.findSecretWord(words, master, allowedGuesses);
        assertEquals(6, master.guess(secret));
    }
}
