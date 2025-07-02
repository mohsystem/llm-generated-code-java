package claude.task115;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task115Test {

    @Test
    void testField1() {
        Task115_CLAUDE_claude_3_5_sonnet_20240620 obj = new Task115_CLAUDE_claude_3_5_sonnet_20240620();
        obj.setField1(2);
        assertEquals(2, obj.getField1(), "Field1 should be 2 after setting to 2");

        obj.setField1(3);
        assertEquals(3, obj.getField1(), "Field1 should be 3 after setting to 3");

        obj.setField1(0);
        assertEquals(0, obj.getField1(), "Field1 should be 0 after setting to 0");
    }

    @Test
    void testField2() {
        Task115_CLAUDE_claude_3_5_sonnet_20240620 obj = new Task115_CLAUDE_claude_3_5_sonnet_20240620();
        obj.setField2(5);
        assertEquals(5, obj.getField2(), "Field2 should be 5 after setting to 5");

        obj.setField2(7);
        assertEquals(7, obj.getField2(), "Field2 should be 7 after setting to 7");

        obj.setField2(0);
        assertEquals(0, obj.getField2(), "Field2 should be 0 after setting to 0");
    }

    @Test
    void testField3() {
        Task115_CLAUDE_claude_3_5_sonnet_20240620 obj = new Task115_CLAUDE_claude_3_5_sonnet_20240620();
        obj.setField3(true);
        assertTrue(obj.getField3(), "Field3 should be true after setting to true");

        obj.setField3(false);
        assertFalse(obj.getField3(), "Field3 should be false after setting to false");
    }

    @Test
    void testCombinedFields() {
        Task115_CLAUDE_claude_3_5_sonnet_20240620 obj = new Task115_CLAUDE_claude_3_5_sonnet_20240620();

        obj.setField1(1);
        obj.setField2(3);
        obj.setField3(true);

        assertEquals(1, obj.getField1(), "Field1 should be 1");
        assertEquals(3, obj.getField2(), "Field2 should be 3");
        assertTrue(obj.getField3(), "Field3 should be true");

        obj.setField1(2);
        obj.setField2(4);
        obj.setField3(false);

        assertEquals(2, obj.getField1(), "Field1 should be 2");
        assertEquals(4, obj.getField2(), "Field2 should be 4");
        assertFalse(obj.getField3(), "Field3 should be false");
    }
}
