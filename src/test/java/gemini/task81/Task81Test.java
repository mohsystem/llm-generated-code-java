package gemini.task81;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Task81Test {

    @Test
    public void testCalculateCertificateHashIsNotEmpty() {
        String certificatePath = "path/to/certificate.crt"; // Replace with a valid certificate path
        String hashAlgorithm = "SHA-256"; // Replace with the hash algorithm you want to use

        try {
            String hash = Task81_GEMINI_gemini_1_5_pro_001.calculateCertificateHash(certificatePath, hashAlgorithm);
            assertNotNull(hash, "Hash should not be null");
            assertFalse(hash.isEmpty(), "Hash should not be empty");
            System.out.println("✔ Certificate hash: " + hash);
        } catch (IOException | NoSuchAlgorithmException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testVerifyCertificateHashMatches() {
        String certificatePath = "path/to/certificate.crt"; // Replace with a valid certificate path
        String expectedHash = "expectedHashValue"; // Replace with the expected hash value
        String hashAlgorithm = "SHA-256"; // Replace with the hash algorithm you want to use

        try {
            boolean isValid = Task81_GEMINI_gemini_1_5_pro_001.verifyCertificateHash(certificatePath, expectedHash, hashAlgorithm);
            assertTrue(isValid, "Certificate hash should match the expected value");
        } catch (IOException | NoSuchAlgorithmException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidCertificatePath() {
        String invalidPath = "invalid/certificate/path.crt";
        String expectedHash = "expectedHashValue";
        String hashAlgorithm = "SHA-256";

        assertThrows(IOException.class, () -> {
            Task81_GEMINI_gemini_1_5_pro_001.verifyCertificateHash(invalidPath, expectedHash, hashAlgorithm);
        }, "Expected an IOException for invalid certificate path, but none was thrown.");
    }

    @Test
    public void testInvalidHashAlgorithm() {
        String certificatePath = "path/to/certificate.crt";
        String expectedHash = "expectedHashValue";
        String invalidHashAlgorithm = "INVALID_ALGORITHM"; // Invalid algorithm

        assertThrows(NoSuchAlgorithmException.class, () -> {
            Task81_GEMINI_gemini_1_5_pro_001.verifyCertificateHash(certificatePath, expectedHash, invalidHashAlgorithm);
        }, "Expected a NoSuchAlgorithmException for invalid hash algorithm, but none was thrown.");
    }
}
