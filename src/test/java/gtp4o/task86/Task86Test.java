package gtp4o.task86;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class Task86Test {

    @Test
    public void testUrlIsValid() throws Exception {
        String urlStr = "http://example.com/program.exe";
        URL url = new URL(urlStr);

        assertEquals("http", url.getProtocol());
        assertEquals("example.com", url.getHost());
        assertEquals("/program.exe", url.getPath());
    }

    @Test
    public void testFileNameExtraction() {
        String url = "http://example.com/program.exe";
        String expectedFileName = "program.exe";
        String actualFileName = url.substring(url.lastIndexOf('/') + 1);

        assertEquals(expectedFileName, actualFileName);
    }

    @Test
    public void testProcessBuilderCommand() {
        String fileName = "downloaded_program.exe";
        String absolutePath = Paths.get(fileName).toAbsolutePath().toString();

        ProcessBuilder builder = new ProcessBuilder(absolutePath);
        assertEquals(1, builder.command().size());
        assertEquals(absolutePath, builder.command().get(0));
    }
}
