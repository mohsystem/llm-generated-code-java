package claude2.task120;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task120_CLAUDE_claude_3_5_sonnet_20240620 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String userInput = request.getParameter("userInput");
        
        out.println("<html><body>");
        out.println("<h2>User Input:</h2>");
        out.println("<p>" + userInput + "</p>");
        out.println("</body></html>");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Enter your input:</h2>");
        out.println("<form method=\'post\'>");
        out.println("<input type=\'text\' name=\'userInput\'>");
        out.println("<input type=\'submit\' value=\'Submit\'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
