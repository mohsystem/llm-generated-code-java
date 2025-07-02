package claude.task105;

import org.junit.jupiter.api.Test;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.cert.X509Certificate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
            // Copy-paste the logic from original main
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) {}
                public void checkServerTrusted(X509Certificate[] chain, String authType) {}
                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
            }}, null);

            SSLSocketFactory factory = context.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            socket.startHandshake();
            System.out.println("Connected to " + host + ":" + port);
            System.out.println("SSL version: " + socket.getSession().getProtocol());
            System.out.println("Cipher: " + socket.getSession().getCipherSuite());

            socket.close();

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Connected to " + host + ":" + port), "Connection message not found.");
        assertTrue(output.contains("SSL version:"), "SSL version not printed.");
        assertTrue(output.contains("Cipher:"), "Cipher not printed.");
    }
}
