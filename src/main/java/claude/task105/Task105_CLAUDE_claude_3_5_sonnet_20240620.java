package claude.task105;

import javax.net.ssl.*;
import java.io.*;

public class Task105_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        String host = "example.com";
        int port = 443;

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            socket.startHandshake();

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
