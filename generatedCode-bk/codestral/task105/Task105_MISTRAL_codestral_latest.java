package codestral.task105;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class Task105_MISTRAL_codestral_latest {
    public static void main(String[] args) throws IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("www.example.com", 443);

        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        // Use inputStream and outputStream to communicate with the server

        sslSocket.close();
    }
}