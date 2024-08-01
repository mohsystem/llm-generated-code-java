package gtp4o.task120;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task120_OPENAI_gpt_4o extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userInput = request.getParameter("userInput");
        out.println("<html><body>");
        out.println("<h1>User Input:</h1>");
        out.println("<p>" + userInput + "</p>");
        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}