package llama3.task38;

import javax.servlet.http.*;
import java.io.*;

public class Task38_PERPLEXITY_llama_3_sonar_large_32k_chat extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, " + name + "!</h1>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form action=\"\" method=\"post\">");
        out.println("    <input type=\"text\" name=\"name\" placeholder=\"Enter your name\">");
        out.println("    <input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
    }
}