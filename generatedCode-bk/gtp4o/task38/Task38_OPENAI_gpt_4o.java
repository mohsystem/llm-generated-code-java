package gtp4o.task38;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task38_OPENAI_gpt_4o extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("userInput");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>You entered: " + userInput + "</h1>");
        out.println("</body></html>");
    }
}