package codestral.task105;

import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Task105Test {

    @Test
    public void testSSLConnectionToGoogle() {
        String server = "www.google.com";
        int port = 443;

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(server, port);

            socket.startHandshake();

            System.out.println("Connected to " + server + ":" + port);
            System.out.println("SSL version: " + socket.getSession().getProtocol());
            System.out.println("Cipher: " + socket.getSession().getCipherSuite());

            socket.close();

        } catch (IOException e) {
            fail("Exception during SSL handshake: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Connected to " + server + ":" + port), "Connection message not found.");
        assertTrue(output.contains("SSL version:"), "SSL version not printed.");
        assertTrue(output.contains("Cipher:"), "Cipher not printed.");
    }
}
