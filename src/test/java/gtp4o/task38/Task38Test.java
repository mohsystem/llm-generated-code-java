package gtp4o.task38;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Task38Test {

    @Test
    void testDoPostWithInput() throws IOException, ServletException {
        Task38_OPENAI_gpt_4o servlet = new Task38_OPENAI_gpt_4o();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("user_input")).thenReturn("Alice");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Mockito.when(response.getWriter()).thenReturn(pw);

        servlet.doPost(request, response);
        pw.flush();

        String output = sw.toString();
        assertTrue(output.contains("<h1>Alice</h1>"));
    }

    @Test
    void testDoPostWithEmptyInput() throws IOException, ServletException {
        Task38_OPENAI_gpt_4o servlet = new Task38_OPENAI_gpt_4o();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("user_input")).thenReturn("");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Mockito.when(response.getWriter()).thenReturn(pw);

        servlet.doPost(request, response);
        pw.flush();

        String output = sw.toString();
        assertTrue(output.contains("<h1></h1>"));
    }

    @Test
    void testDoPostWithNullInput() throws IOException, ServletException {
        Task38_OPENAI_gpt_4o servlet = new Task38_OPENAI_gpt_4o();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("user_input")).thenReturn(null);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Mockito.when(response.getWriter()).thenReturn(pw);

        servlet.doPost(request, response);
        pw.flush();

        String output = sw.toString();
        assertTrue(output.contains("<h1>null</h1>"));
    }
}
