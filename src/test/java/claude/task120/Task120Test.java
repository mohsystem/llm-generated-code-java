package claude.task120;

import jakarta.servlet.Servlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.junit.jupiter.api.*;

import okhttp3.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Task120Test {

    private Server server;
    private static final int PORT = 8085;
    private static final String BASE_URL = "http://localhost:" + PORT + "/";

    @BeforeAll
    public void startServer() throws Exception {
        server = new Server(PORT);
        ServletHandler handler = new ServletHandler();
        server.setHandler((Handler) handler);
        handler.addServletWithMapping((Class<? extends Servlet>) Task120_CLAUDE_claude_3_5_sonnet_20240620.class, "/");
        server.start();
        System.out.println("🚀 Jetty started on http://localhost:" + PORT);
    }

    @AfterAll
    public void stopServer() throws Exception {
        if (server != null && server.isRunning()) {
            server.stop();
            System.out.println("🛑 Jetty stopped.");
        }
    }

    @Test
    @Timeout(10)
    public void testGetForm() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(BASE_URL).build();
        Response response = client.newCall(request).execute();
        String body = response.body().string();

        assertTrue(body.contains("<form method='post'>"), "Form tag not found");
        assertTrue(body.contains("name='user_input'"), "Input field missing");
        assertTrue(body.contains("type='submit'"), "Submit button missing");
    }

    @Test
    @Timeout(10)
    public void testPostInputDisplayed() throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("user_input", "Test123")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        assertTrue(body.contains("<p>Test123</p>"), "Input not echoed correctly");
    }

    @Test
    @Timeout(10)
    public void testPostEmptyInput() throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("user_input", "")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        assertTrue(body.contains("<p></p>"), "Empty input not handled correctly");
    }
}
