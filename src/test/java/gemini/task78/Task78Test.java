package gemini.task78;

import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.security.Security;

import static org.junit.jupiter.api.Assertions.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Task78Test {

    @Test
    public void testGeneratedPEMFile() throws Exception {
        // Ensure BouncyCastle is added
        Security.addProvider(new BouncyCastleProvider());

        // Delete the file if it exists from previous runs
        File pemFile = new File("id_rsa");
        if (pemFile.exists()) pemFile.delete();

        // Run the main method
        Task78_GEMINI_gemini_1_5_pro_001.main(new String[]{});

        // Check file exists
        assertTrue(pemFile.exists(), "PEM file 'id_rsa' should exist after running main");

        // Read file content
        try (PemReader pemReader = new PemReader(new FileReader(pemFile))) {
            PemObject pemObject = pemReader.readPemObject();
            assertNotNull(pemObject, "PEM object should not be null");
            assertEquals("OPENSSH PRIVATE KEY", pemObject.getType(), "PEM type should be 'OPENSSH PRIVATE KEY'");
            assertTrue(pemObject.getContent().length >= 1000, "Key content should be at least 1000 bytes");
        }
    }
}
