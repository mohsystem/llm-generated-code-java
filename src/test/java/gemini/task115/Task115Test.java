package gemini.task115;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task115Test {

    @Test
    void testFlag1Extraction() {
        PackedData data = new PackedData(0b00000001);
        assertEquals(1, data.flag1, "Flag1 should be 1");

        data = new PackedData(0b00000000);
        assertEquals(0, data.flag1, "Flag1 should be 0");

        data = new PackedData(0b11111110);
        assertEquals(0, data.flag1, "Flag1 should be 0 when bit 0 is 0");
    }

    @Test
    void testFlag2Extraction() {
        PackedData data = new PackedData(0b00000110);
        assertEquals(3, data.flag2, "Flag2 should be 3 (bits 1 and 2 are 11)");

        data = new PackedData(0b00000010);
        assertEquals(1, data.flag2, "Flag2 should be 1 (bits 1 and 2 are 01)");

        data = new PackedData(0b00000000);
        assertEquals(0, data.flag2, "Flag2 should be 0 (bits 1 and 2 are 00)");
    }

    @Test
    void testValue2Extraction() {
        PackedData data = new PackedData(0b11111000);
        assertEquals(31, data.value2, "Value2 should be 31 (bits 3-7 are 11111)");

        data = new PackedData(0b00001000);
        assertEquals(1, data.value2, "Value2 should be 1 (bits 3-7 are 00001)");

        data = new PackedData(0b00000000);
        assertEquals(0, data.value2, "Value2 should be 0 (bits 3-7 are 00000)");
    }

    @Test
    void testCombinedExtraction() {
        PackedData data = new PackedData(0b10101101);

        assertEquals(1, data.flag1, "Flag1 should be 1 (bit 0 is 1)");
        assertEquals(2, data.flag2, "Flag2 should be 2 (bits 1 and 2 are 10)");
        assertEquals(21, data.value2, "Value2 should be 21 (bits 3-7 are 10101)");
    }
}
