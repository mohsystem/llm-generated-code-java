package gemini.task53;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Task53Test {

    private Task53_GEMINI_gemini_1_5_pro_001 servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private StringWriter responseWriter;

    @BeforeEach
    public void setUp() throws Exception {
        servlet = new Task53_GEMINI_gemini_1_5_pro_001();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        responseWriter = new StringWriter();

        when(request.getSession()).thenReturn(session);
        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }

    @Test
    public void testFirstVisit() throws Exception {
        when(session.getAttribute("visits")).thenReturn(null);

        servlet.doGet(request, response);

        verify(session).setAttribute("visits", 1);
        assertTrue(responseWriter.toString().contains("1 times"));
    }

    @Test
    public void testSecondVisit() throws Exception {
        when(session.getAttribute("visits")).thenReturn(3);

        servlet.doGet(request, response);

        verify(session).setAttribute("visits", 4);
        assertTrue(responseWriter.toString().contains("4 times"));
    }

    @Test
    public void testSessionIsRetrieved() throws Exception {
        servlet.doGet(request, response);
        verify(request).getSession();
    }

    @Test
    public void testSessionAttributeSet() throws Exception {
        when(session.getAttribute("visits")).thenReturn(null);

        servlet.doGet(request, response);

        verify(session).setAttribute(eq("visits"), anyInt());
    }

    @Test
    public void testResponseWriterUsed() throws Exception {
        servlet.doGet(request, response);
        assertNotNull(responseWriter.toString());
    }

    @Test
    public void testCorrectVisitIncrement() throws Exception {
        when(session.getAttribute("visits")).thenReturn(9);

        servlet.doGet(request, response);

        verify(session).setAttribute("visits", 10);
        assertTrue(responseWriter.toString().contains("10 times"));
    }

    @Test
    public void testMultipleCalls() throws Exception {
        when(session.getAttribute("visits")).thenReturn(2);
        servlet.doGet(request, response);
        verify(session).setAttribute("visits", 3);
    }

    @Test
    public void testSessionNullHandling() throws Exception {
        when(session.getAttribute("visits")).thenReturn(null);
        servlet.doGet(request, response);
        verify(session).setAttribute("visits", 1);
    }

    @Test
    public void testPrintsCorrectMessage() throws Exception {
        when(session.getAttribute("visits")).thenReturn(5);
        servlet.doGet(request, response);
        assertTrue(responseWriter.toString().contains("6 times"));
    }

    @Test
    public void testWriterCalledOnce() throws Exception {
        servlet.doGet(request, response);
        verify(response, times(1)).getWriter();
    }
}
