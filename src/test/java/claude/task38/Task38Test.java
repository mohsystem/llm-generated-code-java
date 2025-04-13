package claude.task38;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Task38Test {

    @Test
    void testDoPostWithName() throws IOException, ServletException {
        // Arrange
        Task38_CLAUDE_claude_3_5_sonnet_20240620 servlet = new Task38_CLAUDE_claude_3_5_sonnet_20240620();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Define test input and expected output
        String inputName = "Alice";
        String expectedOutput = "<h1>Hello, Alice!</h1>";

        // Set up mock behavior
        Mockito.when(request.getParameter("name")).thenReturn(inputName);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Mockito.when(response.getWriter()).thenReturn(printWriter);

        // Act
        servlet.doPost(request, response);
        printWriter.flush();

        // Assert
        String responseContent = stringWriter.toString();
        assertTrue(responseContent.contains(expectedOutput));
    }

    @Test
    void testDoPostWithEmptyName() throws IOException, ServletException {
        Task38_CLAUDE_claude_3_5_sonnet_20240620 servlet = new Task38_CLAUDE_claude_3_5_sonnet_20240620();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("name")).thenReturn("");

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Mockito.when(response.getWriter()).thenReturn(printWriter);

        servlet.doPost(request, response);
        printWriter.flush();

        String responseContent = stringWriter.toString();
        assertTrue(responseContent.contains("<h1>Hello, !</h1>"));
    }

    @Test
    void testDoPostWithNullName() throws IOException, ServletException {
        Task38_CLAUDE_claude_3_5_sonnet_20240620 servlet = new Task38_CLAUDE_claude_3_5_sonnet_20240620();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("name")).thenReturn(null);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Mockito.when(response.getWriter()).thenReturn(printWriter);

        servlet.doPost(request, response);
        printWriter.flush();

        String responseContent = stringWriter.toString();
        assertTrue(responseContent.contains("<h1>Hello, null!</h1>"));
    }
}
