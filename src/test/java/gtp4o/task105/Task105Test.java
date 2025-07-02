package gtp4o.task105;

import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task105Test {

    @Test
    public void testSSLProtocolPrinted() {
        String host = "www.google.com";
        int port = 443;

        // Capture system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.startHandshake();

            System.out.println(socket.getSession().getProtocol());

            socket.close();
        } catch (IOException e) {
            fail("SSL Handshake failed: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString().trim();

         assertFalse(output.isEmpty(), "No protocol printed.");
        assertTrue(output.matches("TLS.*"), "Expected TLS version but got: " + output);
    }
}
