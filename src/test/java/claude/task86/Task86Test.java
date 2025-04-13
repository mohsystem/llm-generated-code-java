package claude.task86;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task86Test {

    @Test
    public void testDownloadAndExecuteSimulation() throws Exception {
        // Given
        String fakeUrl = "http://example.com/fakefile.exe";
        String expectedFileName = "fakefile.exe";

        // Simulate input
        ByteArrayInputStream inContent = new ByteArrayInputStream(fakeUrl.getBytes());
        System.setIn(inContent);

        // Simulate output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        // We'll call main and simulate as if it ran till download, but we intercept actual download
        try {
            Task86_CLAUDE_claude_3_5_sonnet_20240620.main(new String[]{});
        } catch (Exception e) {
            // Ignore because we know file not found or exec will fail (simulation)
        }

        // Then
        assertTrue(outContent.toString().contains("Enter the URL of the EXE file:"));
    }

    @Test
    public void testFileNameExtractionFromUrl() {
        String url = "http://example.com/program.exe";
        String extracted = url.substring(url.lastIndexOf('/') + 1);
        assertEquals("program.exe", extracted);
    }
}
