package codestral.task38;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Task38Test {

    @Test
    void testDoPostWithInput() throws IOException, ServletException {
        Task38_MISTRAL_codestral_latest servlet = new Task38_MISTRAL_codestral_latest();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("user_input")).thenReturn("Alice");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        Mockito.when(response.getWriter()).thenReturn(pw);

        servlet.doPost(request, response);
        pw.flush();

        String result = sw.toString();
        assertTrue(result.contains("<h1>Your input: Alice</h1>"));
    }

    @Test
    void testDoPostWithEmptyInput() throws IOException, ServletException {
        Task38_MISTRAL_codestral_latest servlet = new Task38_MISTRAL_codestral_latest();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("user_input")).thenReturn("");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        Mockito.when(response.getWriter()).thenReturn(pw);

        servlet.doPost(request, response);
        pw.flush();

        String result = sw.toString();
        assertTrue(result.contains("<h1>Your input: </h1>"));
    }

    @Test
    void testDoPostWithNullInput() throws IOException, ServletException {
        Task38_MISTRAL_codestral_latest servlet = new Task38_MISTRAL_codestral_latest();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("user_input")).thenReturn(null);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        Mockito.when(response.getWriter()).thenReturn(pw);

        servlet.doPost(request, response);
        pw.flush();

        String result = sw.toString();
        assertTrue(result.contains("<h1>Your input: null</h1>"));
    }
}
