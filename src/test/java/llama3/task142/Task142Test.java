package llama3.task142;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Task142_PERPLEXITY_llama_3_sonar_large_32k_chatTest {

    @Test
    void testSameNumbers() {
        assertEquals(5, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(5, 5));
    }

    @Test
    void testOneNumberIsOne() {
        assertEquals(1, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(1, 100));
        assertEquals(1, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(100, 1));
    }

    @Test
    void testOneNumberZero() {
        assertEquals(7, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(7, 0));
        assertEquals(9, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(0, 9));
        assertEquals(0, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(0, 0));
    }

    @Test
    void testPrimeNumbers() {
        assertEquals(1, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(17, 31));
        assertEquals(1, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(13, 29));
    }

    @Test
    void testLargeNumbers() {
        assertEquals(28, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(12348, 700));
    }

    @Test
    void testCoprimeNumbers() {
        assertEquals(1, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(35, 64));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(5, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(-10, 15));
        assertEquals(7, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(21, -14));
        assertEquals(4, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(-8, -12));
    }

    @Test
    void testIdenticalLargeNumbers() {
        assertEquals(123456, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(123456, 123456));
    }

    @Test
    void testSmallAndLargeNumbers() {
        assertEquals(1, Task142_PERPLEXITY_llama_3_sonar_large_32k_chat.gcd(3, 1000000));
    }

}
