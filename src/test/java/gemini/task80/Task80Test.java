package gemini.task80;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

class Task80Test {

    // اختبر الاتصال عبر SSL باستخدام IPv6
    @Test
    void testCreateSSLClientSocketIPv6() {
        String hostname = "2001:db8::ff00:42:8329";  // استخدم عنوان IPv6 صالح هنا
        int port = 443;

        try {
            // إنشاء الاتصال عبر SSL و IPv6
            SSLSocket sslSocket = Task80_GEMINI_gemini_1_5_pro_001.createSSLClientSocketIPv6(hostname, port);

            // تحقق مما إذا كان الاتصال ناجحًا
            assertNotNull(sslSocket, "The SSL socket should not be null");

            // تحقق من أن الاتصال تم باستخدام IPv6
            assertTrue(sslSocket.isConnected(), "The socket should be connected");

            // أغلق الاتصال بعد التحقق
            sslSocket.close();
        } catch (IOException e) {
            fail("An exception was thrown while creating the SSL socket: " + e.getMessage());
        }
    }
}
