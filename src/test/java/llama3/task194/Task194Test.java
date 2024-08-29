package llama3.task194;

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
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase2() {
        String secret = "hamada";
        String[] words = {"hamada", "khaled"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase3() {
        String secret = "abcdef";
        String[] words = {"abcdef", "bbcdef", "abcfef", "abcfeg"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase4() {
        String secret = "xyzxyz";
        String[] words = {"xyzxyz", "yzxzyz", "zyxzyx", "xyzzyz"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase5() {
        String secret = "abcdef";
        String[] words = {"abcdef", "bcdefg", "cdefgh", "defghi"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase6() {
        String secret = "hello";
        String[] words = {"hello", "hallo", "hullo", "hollo"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase7() {
        String secret = "secret";
        String[] words = {"secret", "secrep", "secreq", "secrer"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase8() {
        String secret = "example";
        String[] words = {"example", "exempla", "exemlpe", "exemal"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase9() {
        String secret = "solver";
        String[] words = {"solver", "solvers", "solves", "solverr"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    @Test
    void testCase10() {
        String secret = "worlds";
        String[] words = {"worlds", "wordss", "woldrs", "wolrds"};
        Master master = new MockMaster(secret);

        solution.findSecretWord(words, master);
        assertEquals(6, master.guess(secret));
    }

    // Mock implementation of the Master class
    static class MockMaster extends Master {
        private final String secret;

        MockMaster(String secret) {
            this.secret = secret;
        }

        @Override
        public int guess(String word) {
            if (word.length() != secret.length()) return -1;
            int matches = 0;
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == word.charAt(i)) matches++;
            }
            return matches;
        }
    }
}
