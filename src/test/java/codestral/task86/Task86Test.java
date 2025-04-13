package codestral.task86;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

public class Task86Test {

    @Test
    public void testFileNameExtraction() {
        String url = "http://example.com/program.exe";
        String expectedFileName = "program.exe";
        String actualFileName = url.substring(url.lastIndexOf('/') + 1);

        assertEquals(expectedFileName, actualFileName);
    }

    @Test
    public void testValidUrlFormat() throws Exception {
        String urlStr = "http://example.com/program.exe";
        URL url = new URL(urlStr);
        assertEquals("http", url.getProtocol());
        assertEquals("example.com", url.getHost());
        assertEquals("/program.exe", url.getPath());
    }

 }
