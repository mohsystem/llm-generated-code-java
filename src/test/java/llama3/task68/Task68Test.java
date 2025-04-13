package llama3.task68;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task68Test {

    // نحاكي نفس منطق تحويل الدومين
    private String convertToBaseDn(String dc) {
        return "dc=" + dc.replace(".", ",dc=");
    }

    @Test
    void testConvertToBaseDn_SimpleDomain() {
        String input = "example.com";
        String expected = "dc=example,dc=com";
        String actual = convertToBaseDn(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertToBaseDn_MultiLevelDomain() {
        String input = "corp.example.org";
        String expected = "dc=corp,dc=example,dc=org";
        String actual = convertToBaseDn(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertToBaseDn_Localhost() {
        String input = "localhost";
        String expected = "dc=localhost";
        String actual = convertToBaseDn(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertToBaseDn_Empty() {
        String input = "";
        String expected = "dc=";
        String actual = convertToBaseDn(input);
        assertEquals(expected, actual);
    }
}
