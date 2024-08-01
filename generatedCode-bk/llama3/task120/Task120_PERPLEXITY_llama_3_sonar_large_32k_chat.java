package llama3.task120;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task120_PERPLEXITY_llama_3_sonar_large_32k_chat extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userInput = request.getParameter("userInput");
        out.println("<html><body>");
        out.println("You entered: " + userInput);
        out.println("</body></html>");
    }
}