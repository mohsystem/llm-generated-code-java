package gemini.task86;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class Task86Test {

    @Test
    public void testExtractedFileNameFromUrl() {
        String url = "https://example.com/test.exe";
        String expected = "test.exe";
        String actual = url.substring(url.lastIndexOf('/') + 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testValidUrlFormat() throws Exception {
        String urlStr = "https://example.com/downloaded_file.exe";
        URL url = new URL(urlStr);
        assertEquals("https", url.getProtocol());
        assertEquals("example.com", url.getHost());
        assertEquals("/downloaded_file.exe", url.getPath());
    }

    @Test
    public void testProcessBuilderCommand() {
        String filename = "downloaded_file.exe";
        ProcessBuilder processBuilder = new ProcessBuilder(filename);
        assertEquals(1, processBuilder.command().size());
        assertEquals(filename, processBuilder.command().get(0));
    }
}
