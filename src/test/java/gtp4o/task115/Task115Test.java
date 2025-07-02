package gtp4o.task115;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task115Test {

    @Test
    void testConstructorAndFields() {
        Task115_OPENAI_gpt_4o obj = new Task115_OPENAI_gpt_4o(1, 2, 5);

        assertEquals(1, obj.a, "Field a should be 1");
        assertEquals(2, obj.b, "Field b should be 2");
        assertEquals(5, obj.c, "Field c should be 5");
    }

    @Test
    void testDifferentValues() {
        Task115_OPENAI_gpt_4o obj = new Task115_OPENAI_gpt_4o(10, 20, 30);

        assertEquals(10, obj.a, "Field a should be 10");
        assertEquals(20, obj.b, "Field b should be 20");
        assertEquals(30, obj.c, "Field c should be 30");
    }

    @Test
    void testNegativeValues() {
        Task115_OPENAI_gpt_4o obj = new Task115_OPENAI_gpt_4o(-1, -2, -3);

        assertEquals(-1, obj.a, "Field a should be -1");
        assertEquals(-2, obj.b, "Field b should be -2");
        assertEquals(-3, obj.c, "Field c should be -3");
    }
}
