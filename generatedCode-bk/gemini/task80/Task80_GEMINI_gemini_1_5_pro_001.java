package gemini.task80;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class Task80_GEMINI_gemini_1_5_pro_001 {

    public static SSLSocket createSSLSocket(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        return (SSLSocket) factory.createSocket(host, port);
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket = createSSLSocket("localhost", 8443);
            System.out.println("Connected to: " + socket.getInetAddress() + ":" + socket.getPort());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}