package gemini.task105;

import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task105Test {

    @Test
    public void testSSLConnectionToGoogle() {
        String host = "www.google.com";
        int port = 443;

        // Capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            System.out.println("Connected to " + socket.getInetAddress().getHostName() + " on port " + socket.getPort());
            System.out.println("SSL/TLS version: " + socket.getSession().getProtocol());
            System.out.println("Cipher suite: " + socket.getSession().getCipherSuite());

            socket.close();

        } catch (Exception e) {
            fail("Exception during SSL connection: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Connected to " + host), "Connection message not found.");
        assertTrue(output.contains("on port " + port), "Port info not printed.");
        assertTrue(output.contains("SSL/TLS version:"), "SSL version not printed.");
        assertTrue(output.contains("Cipher suite:"), "Cipher suite not printed.");
    }
}
