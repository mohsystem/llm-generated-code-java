package llama3.task105;

import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task105Test {

    @Test
    public void testSSLConnectionAndWrite() {
        String host = "www.google.com";
        int port = 443;

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("GET / HTTP/1.1\r\nHost: " + host + "\r\n\r\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine = in.readLine();

            assertNotNull(responseLine, "Response should not be null");
            assertTrue(responseLine.startsWith("HTTP"), "Response should start with HTTP");

            socket.close();

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
