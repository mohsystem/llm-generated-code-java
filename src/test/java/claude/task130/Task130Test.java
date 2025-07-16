package claude.task130;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.jupiter.api.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class Task130Test {

    static Server server;

    // --------------- CORS Filter -----------------
    public static class Task130_CLAUDE_claude_3_5_sonnet_20240620 implements Filter {
        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
            chain.doFilter(req, res);
        }
        @Override public void init(FilterConfig filterConfig) {}
        @Override public void destroy() {}
    }

    // --------------- Simple Servlet /api/data ---------------
    public static class DataServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("application/json");
            resp.getWriter().write("{\"message\":\"This is CORS-enabled data\"}");
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @BeforeAll
    public static void startServer() throws Exception {
        server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add CORS filter to all paths
        FilterHolder corsFilter = new FilterHolder(new Task130_CLAUDE_claude_3_5_sonnet_20240620());
        context.addFilter(corsFilter, "/*", null);

        // Add servlet /api/data
        context.addServlet(DataServlet.class, "/api/data");

        server.start();
    }

    @AfterAll
    public static void stopServer() throws Exception {
        server.stop();
    }

    @Test
    public void testCorsHeaders() throws Exception {
        URL url = new URL("http://localhost:8080/api/data");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        String allowOrigin = con.getHeaderField("Access-Control-Allow-Origin");
        String allowMethods = con.getHeaderField("Access-Control-Allow-Methods");
        String allowHeaders = con.getHeaderField("Access-Control-Allow-Headers");
        String maxAge = con.getHeaderField("Access-Control-Max-Age");

        if (status == 200) {
            System.out.println("Test GET status: pass");
        } else {
            System.out.println("Test GET status: fail");
        }
        assertEquals(200, status);

        if ("*".equals(allowOrigin)) {
            System.out.println("Test Access-Control-Allow-Origin header: pass");
        } else {
            System.out.println("Test Access-Control-Allow-Origin header: fail");
        }
        assertEquals("*", allowOrigin);

        if (allowMethods != null && allowMethods.contains("GET")) {
            System.out.println("Test Access-Control-Allow-Methods header: pass");
        } else {
            System.out.println("Test Access-Control-Allow-Methods header: fail");
        }
        assertTrue(allowMethods != null && allowMethods.contains("GET"));

        if (allowHeaders != null && allowHeaders.contains("Content-Type")) {
            System.out.println("Test Access-Control-Allow-Headers header: pass");
        } else {
            System.out.println("Test Access-Control-Allow-Headers header: fail");
        }
        assertTrue(allowHeaders != null && allowHeaders.contains("Content-Type"));

        if ("3600".equals(maxAge)) {
            System.out.println("Test Access-Control-Max-Age header: pass");
        } else {
            System.out.println("Test Access-Control-Max-Age header: fail");
        }
        assertEquals("3600", maxAge);
    }
}
