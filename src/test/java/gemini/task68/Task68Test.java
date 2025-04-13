package gemini.task68;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task68Test {

     private String convertToBaseDn(String domainComponent) {
        return "dc=" + domainComponent.replace(".", ",dc=");
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
    void testConvertToBaseDn_SingleDomain() {
        String input = "localhost";
        String expected = "dc=localhost";
        String actual = convertToBaseDn(input);
        assertEquals(expected, actual);
    }
}
