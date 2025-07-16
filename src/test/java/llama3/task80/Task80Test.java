package llama3.task80;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.Inet6Address;

class Task80Test {

    // اختبر الاتصال عبر SSL باستخدام IPv6
    @Test
    void testCreateSSLClientSocket() {
        String host = "2001:db8::ff00:42:8329";  // استخدم عنوان IPv6 صالح هنا
        int port = 443;

        try {
            // إنشاء الاتصال عبر SSL و IPv6
            SSLSocket sslSocket = Task80_PERPLEXITY_llama_3_sonar_large_32k_chat.createSSLClientSocket(host, port);

            // تحقق مما إذا كان الاتصال ناجحًا
            assertNotNull(sslSocket, "The SSL socket should not be null");

            // تحقق من أن الاتصال تم باستخدام IPv6
            assertTrue(sslSocket.isConnected(), "The socket should be connected");

            // تحقق من نوع العنوان إذا كان من نوع Inet6Address
            assertTrue(sslSocket.getInetAddress() instanceof Inet6Address, "The socket should use an IPv6 address");

            // أغلق الاتصال بعد التحقق
            sslSocket.close();
        } catch (IOException e) {
            fail("An exception was thrown while creating the SSL socket: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
