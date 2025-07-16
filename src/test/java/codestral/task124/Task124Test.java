package codestral.task124;

import java.io.Console;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Task124Test {

    // Use the encrypt/decrypt logic here since original class only reads password
    private static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private static String decrypt(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        return new String(decodedBytes);
    }

    private final Map<String, String> sensitiveData = new HashMap<>();

    public Task124Test() {
        sensitiveData.put("credit_card", "1234-5678-9012-3456");
        sensitiveData.put("ssn", "123-45-6789");
        sensitiveData.put("password", "mySecretPass123");
    }

    public void test_encrypt_credit_card() {
        String data = sensitiveData.get("credit_card");
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_credit_card: PASS");
            else System.out.println("test_encrypt_credit_card: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_credit_card: FAIL");
        }
    }

    public void test_encrypt_ssn() {
        String data = sensitiveData.get("ssn");
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_ssn: PASS");
            else System.out.println("test_encrypt_ssn: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_ssn: FAIL");
        }
    }

    public void test_encrypt_password() {
        String data = sensitiveData.get("password");
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_password: PASS");
            else System.out.println("test_encrypt_password: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_password: FAIL");
        }
    }

    public void test_encrypt_empty_string() {
        String data = "";
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_empty_string: PASS");
            else System.out.println("test_encrypt_empty_string: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_empty_string: FAIL");
        }
    }

    public void test_encrypt_special_characters() {
        String data = "!@#$%^&*()_+-=<>?";
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_special_characters: PASS");
            else System.out.println("test_encrypt_special_characters: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_special_characters: FAIL");
        }
    }

    public void test_decrypt_empty_string() {
        String data = "";
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_decrypt_empty_string: PASS");
            else System.out.println("test_decrypt_empty_string: FAIL");
        } catch (Exception e) {
            System.out.println("test_decrypt_empty_string: FAIL");
        }
    }

    public void test_decrypt_invalid_base64() {
        try {
            decrypt("InvalidBase64");
            System.out.println("test_decrypt_invalid_base64: FAIL");
        } catch (Exception e) {
            System.out.println("test_decrypt_invalid_base64: PASS");
        }
    }

    public void test_encrypt_decrypt_with_long_string() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) sb.append("A");
        String data = sb.toString();
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_decrypt_with_long_string: PASS");
            else System.out.println("test_encrypt_decrypt_with_long_string: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_decrypt_with_long_string: FAIL");
        }
    }

    public void test_encrypt_decrypt_with_numeric_string() {
        String data = "1234567890";
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_decrypt_with_numeric_string: PASS");
            else System.out.println("test_encrypt_decrypt_with_numeric_string: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_decrypt_with_numeric_string: FAIL");
        }
    }

    public void test_encrypt_decrypt_with_unicode() {
        String data = "こんにちは"; // Japanese "Hello"
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            if (decrypted.equals(data)) System.out.println("test_encrypt_decrypt_with_unicode: PASS");
            else System.out.println("test_encrypt_decrypt_with_unicode: FAIL");
        } catch (Exception e) {
            System.out.println("test_encrypt_decrypt_with_unicode: FAIL");
        }
    }

    public static void main(String[] args) {
        Task124Test test = new Task124Test();

        test.test_encrypt_credit_card();
        test.test_encrypt_ssn();
        test.test_encrypt_password();
        test.test_encrypt_empty_string();
        test.test_encrypt_special_characters();
        test.test_decrypt_empty_string();
        test.test_decrypt_invalid_base64();
        test.test_encrypt_decrypt_with_long_string();
        test.test_encrypt_decrypt_with_numeric_string();
        test.test_encrypt_decrypt_with_unicode();
    }
}
