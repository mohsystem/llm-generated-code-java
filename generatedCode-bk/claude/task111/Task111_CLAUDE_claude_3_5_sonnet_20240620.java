package claude.task111;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111_CLAUDE_claude_3_5_sonnet_20240620 {
    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        try {
            WebServer webServer = new WebServer(8080);
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("Calculator", Task111_CLAUDE_claude_3_5_sonnet_20240620.class);
            xmlRpcServer.setHandlerMapping(phm);

            webServer.start();
            System.out.println("XML-RPC Server is running on port 8080");
        } catch (Exception e) {
            System.err.println("XML-RPC Server: " + e);
        }
    }
}
