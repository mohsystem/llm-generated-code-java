package claude.task80;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

class Task80Test {

    // اختبر الاتصال بالخادم عبر IPv6 و SSL
    @Test
    void testCreateSSLIPv6Socket() {
        String host = "2001:db8::ff00:42:8329";  // استخدم عنوان IPv6 صالح هنا
        int port = 443;

        try {
            // إنشاء الاتصال عبر SSL و IPv6
            SSLSocket socket = Task80_CLAUDE_claude_3_5_sonnet_20240620.createSSLIPv6Socket(host, port);

            // تحقق مما إذا كان الاتصال ناجحًا أم لا
            assertNotNull(socket, "The socket should not be null");

            // تحقق من أنه تم الاتصال بالخادم عبر عنوان IPv6
            assertTrue(socket.isConnected(), "The socket should be connected");

            socket.close();  // أغلق الاتصال بعد التحقق
        } catch (IOException e) {
            fail("An exception was thrown while creating the SSL socket: " + e.getMessage());
        }
    }
}
