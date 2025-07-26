package gtp4o.task81;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class Task81Test {

    // استخدام ملف شهادة افتراضي موجود داخل المشروع لاختبار الكود
    private final String certPath = "src/test/resources/your_certificate.crt";  // قم بتعديل المسار لملف الشهادة الافتراضي داخل مشروعك
    private final String knownHash = "your_known_hash_here";  // استبدلها بالهاش المعروف لاختبار المطابقة

    @Test
    public void testGetCertHashIsNotEmpty() {
        // تأكد من وجود الملف قبل اختبار الكود
        if (!Files.exists(Paths.get(certPath))) {
            fail("Certificate file not found at: " + certPath);
        }

        try {
            String hash = Task81_OPENAI_gpt_4o.getCertHash(certPath);
            assertNotNull(hash, "Hash should not be null");
            assertFalse(hash.isEmpty(), "Hash should not be empty");
            System.out.println("✔ Certificate hash: " + hash);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCertificateMatchesKnownHash() {
        // تأكد من وجود الملف قبل اختبار الكود
        if (!Files.exists(Paths.get(certPath))) {
            fail("Certificate file not found at: " + certPath);
        }

        try {
            String certHash = Task81_OPENAI_gpt_4o.getCertHash(certPath);
            assertEquals(knownHash, certHash, "Certificate hash should match the known hash");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCertificateDoesNotMatchKnownHash() {
        // تأكد من وجود الملف قبل اختبار الكود
        if (!Files.exists(Paths.get(certPath))) {
            fail("Certificate file not found at: " + certPath);
        }

        String wrongHash = "wrong_known_hash"; // تغييرها لهاش خاطئ لاختبار عدم المطابقة

        try {
            String certHash = Task81_OPENAI_gpt_4o.getCertHash(certPath);
            assertNotEquals(wrongHash, certHash, "Certificate hash should not match the wrong hash");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidCertificatePath() {
        String invalidPath = "invalid/certificate/path.crt";

        // تأكد من أن الملف غير موجود في المسار المحدد
        if (Files.exists(Paths.get(invalidPath))) {
            fail("Expected file to not exist at: " + invalidPath);
        }

        assertThrows(Exception.class, () -> {
            Task81_OPENAI_gpt_4o.getCertHash(invalidPath);
        }, "Expected an exception for invalid certificate path, but none was thrown.");
    }
}
