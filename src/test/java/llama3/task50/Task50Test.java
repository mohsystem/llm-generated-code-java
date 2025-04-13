package llama3.task50;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task50Test {

    private static final String SERVER_URL = "http://127.0.0.1:5000/upload";
    private static final String FILE_NAME = "testFile.txt";
    private static final String FILE_CONTENT = "This is a test file.";
    private static final String BOUNDARY = "----WebKitFormBoundary7MA4YWxkTrZu0gW";

    @BeforeAll
    public static void setup() throws IOException {
        // إنشاء ملف للاختبار
        Files.writeString(Path.of(FILE_NAME), FILE_CONTENT);
    }

    @Test
    @Order(1)
    public void testFileUpload_ExactMatchToPythonCase() throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(SERVER_URL).openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

        try (OutputStream output = conn.getOutputStream();
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true)) {

            File file = new File(FILE_NAME);

            writer.append("--").append(BOUNDARY).append("\r\n");
            writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"")
                    .append(file.getName()).append("\"\r\n");
            writer.append("Content-Type: application/octet-stream\r\n\r\n").flush();

            Files.copy(file.toPath(), output);
            output.flush();

            writer.append("\r\n").flush();
            writer.append("--").append(BOUNDARY).append("--\r\n").flush();
        }

        int status = conn.getResponseCode();
        assertEquals(200, status, "Status code must be 200 like Python test");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            responseBody.append(line);
        }
        in.close();

        assertEquals("{\"message\":\"File uploaded successfully\"}", responseBody.toString().trim(),
                "Response must exactly match Python test output");
    }

    @AfterAll
    public static void cleanup() {
        try {
            Files.deleteIfExists(Path.of(FILE_NAME));
            Files.deleteIfExists(Path.of("uploads", FILE_NAME)); // إذا السيرفر على نفس الجهاز
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
