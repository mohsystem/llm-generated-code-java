package gtp4o.task142;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task142Test {

    @Test
    void testPositiveIntegers() {
        assertEquals(6, Task142_OPENAI_gpt_4o.gcd(48, 18));
    }

    @Test
    void testSameNumbers() {
        assertEquals(7, Task142_OPENAI_gpt_4o.gcd(7, 7));
    }

    @Test
    void testOneNumberZero() {
        assertEquals(15, Task142_OPENAI_gpt_4o.gcd(0, 15));
        assertEquals(15, Task142_OPENAI_gpt_4o.gcd(15, 0));
    }

    @Test
    void testPrimeNumbers() {
        assertEquals(1, Task142_OPENAI_gpt_4o.gcd(13, 17));
    }

    @Test
    void testOneNumberIsOne() {
        assertEquals(1, Task142_OPENAI_gpt_4o.gcd(1, 25));
        assertEquals(1, Task142_OPENAI_gpt_4o.gcd(25, 1));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-6, Task142_OPENAI_gpt_4o.gcd(-48, -18));
        assertEquals(6, Task142_OPENAI_gpt_4o.gcd(-48, 18));
        assertEquals(-6, Task142_OPENAI_gpt_4o.gcd(48, -18));
    }

    @Test
    void testLargeNumbers() {
        assertEquals(6, Task142_OPENAI_gpt_4o.gcd(123456, 7890));
    }

    @Test
    void testCoprimeNumbers() {
        assertEquals(1, Task142_OPENAI_gpt_4o.gcd(35, 64));
    }

    @Test
    void testSmallAndLargeNumbers() {
        assertEquals(7, Task142_OPENAI_gpt_4o.gcd(7, 1001));
    }

    @Test
    void testIdenticalLargeNumbers() {
        assertEquals(1000000, Task142_OPENAI_gpt_4o.gcd(1000000, 1000000));
    }
}
