package llama3.task115;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task115Test {

    @Test
    void testConstructorAndFields() {
        Task115_PERPLEXITY_llama_3_sonar_large_32k_chat obj = new Task115_PERPLEXITY_llama_3_sonar_large_32k_chat(1, 2, 3);

        assertEquals(1, obj.a, "Field a should be 1");
        assertEquals(2, obj.b, "Field b should be 2");
        assertEquals(3, obj.c, "Field c should be 3");
    }

    @Test
    void testDifferentValues() {
        Task115_PERPLEXITY_llama_3_sonar_large_32k_chat obj = new Task115_PERPLEXITY_llama_3_sonar_large_32k_chat(10, 20, 30);

        assertEquals(10, obj.a, "Field a should be 10");
        assertEquals(20, obj.b, "Field b should be 20");
        assertEquals(30, obj.c, "Field c should be 30");
    }

    @Test
    void testNegativeValues() {
        Task115_PERPLEXITY_llama_3_sonar_large_32k_chat obj = new Task115_PERPLEXITY_llama_3_sonar_large_32k_chat(-5, -10, -15);

        assertEquals(-5, obj.a, "Field a should be -5");
        assertEquals(-10, obj.b, "Field b should be -10");
        assertEquals(-15, obj.c, "Field c should be -15");
    }
}
