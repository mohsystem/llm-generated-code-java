package claude.task8;

import org.junit.jupiter.api.Test;
import static claude.task8.Task8_CLAUDE_claude_3_5_sonnet_20240620.findMissingLetter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8_TestCase {

    @Test
    void test1() {
        assertEquals('e', findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'f'}));
    }

    @Test
    void test2() {
        assertEquals('e', findMissingLetter(new char[] {'b', 'c', 'd', 'f', 'g'}));
    }

    @Test
    void test3() {
        assertEquals('b', findMissingLetter(new char[] {'a', 'c', 'd', 'e', 'f', 'g'}));
    }

    @Test
    void test4() {
        assertEquals('P', findMissingLetter(new char[] {'O', 'Q', 'R', 'S'}));
    }

    @Test
    void test5() {
        assertEquals('F', findMissingLetter(new char[] {'C', 'D', 'E', 'G', 'H'}));
    }

    @Test
    void test6() {
       assertEquals('C', findMissingLetter(new char[] {'A', 'B', 'D', 'E', 'F', 'G'}));
    }

    @Test
    void test7() {
        assertEquals('c', findMissingLetter(new char[] {'a', 'b', 'd'}));
    }

    @Test
    void test8() {
        assertEquals('m', findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'n'}));
    }

    @Test
    void test9() {
        assertEquals('Y', findMissingLetter(new char[] {'X', 'Z'}));
    }

    @Test
    void test10() {
        assertEquals('b', findMissingLetter(new char[] {'a', 'c'}));
    }
}
