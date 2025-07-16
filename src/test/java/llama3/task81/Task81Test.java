package llama3.task81;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class Task81Test {

    // استبدل بالهاش المتوقع الخاص بالشهادة لاختبار المطابقة
    private final String expectedHash = "expected_hash_here";

    @Test
    public void testCertificateHashMatchesExpectedHash() throws Exception {
        String hostname = "example.com"; // استبدله باسم المضيف الذي تريد التحقق منه
        int port = 443; // البورت (عادة 443 للاتصالات SSL)

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) factory.createSocket(hostname, port);

        // الحصول على شهادة الخادم عبر SSL
        javax.net.ssl.SSLSession session = sslSocket.getSession();
        assertNotNull(session, "SSL Session should not be null");

        X509Certificate cert = (X509Certificate) session.getPeerCertificates()[0];

        // حساب الهاش باستخدام SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] derCert = cert.getEncoded();
        byte[] hashBytes = md.digest(derCert);

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        String certHash = hexString.toString();

        // مقارنة الهاش المحسوب مع الهاش المتوقع
        assertEquals(expectedHash, certHash, "Certificate hash should match the expected hash");

        sslSocket.close(); // إغلاق الاتصال بعد الاختبار
    }

    @Test
    public void testCertificateDoesNotMatchExpectedHash() throws Exception {
        String hostname = "example.com"; // استبدله باسم المضيف الذي تريد التحقق منه
        int port = 443; // البورت (عادة 443 للاتصالات SSL)
        String wrongHash = "wrong_known_hash"; // هاش خاطئ لاختبار عدم المطابقة

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) factory.createSocket(hostname, port);

        // الحصول على شهادة الخادم عبر SSL
        javax.net.ssl.SSLSession session = sslSocket.getSession();
        assertNotNull(session, "SSL Session should not be null");

        X509Certificate cert = (X509Certificate) session.getPeerCertificates()[0];

        // حساب الهاش باستخدام SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] derCert = cert.getEncoded();
        byte[] hashBytes = md.digest(derCert);

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        String certHash = hexString.toString();

        // اختبار الهاش الخاطئ
        assertNotEquals(wrongHash, certHash, "Certificate hash should not match the wrong hash");

        sslSocket.close(); // إغلاق الاتصال بعد الاختبار
    }

    @Test
    public void testInvalidCertificateHost() throws Exception {
        String invalidHostname = "invalid-hostname.com"; // اسم مضيف غير صحيح لاختبار الشهادة
        int port = 443;

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) factory.createSocket(invalidHostname, port);

        // التحقق من وجود خطأ في الاتصال بسبب اسم المضيف غير الصحيح
        assertThrows(Exception.class, sslSocket::getSession, "Expected an exception for invalid hostname, but none was thrown.");
    }
}
