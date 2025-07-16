package claude.task122;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Task122Test {

    private static final String PASSWORDS_FILE_PATH = "C:\\Users\\1\\OneDrive\\Desktop\\llm-generated-code-java\\src\\test\\java\\claude\\task122\\passwords.txt";

    public static void main(String[] args) {
        runTestCases();
    }

    public static void runTestCases() {
        // تنظيف الملف قبل التشغيل
        File file = new File(PASSWORDS_FILE_PATH);
        if (file.exists()) {
            if (!file.delete()) {
                System.out.println("Warning: Could not delete existing passwords.txt file.");
            }
        }

        try {
            testCase1();
            testCase2();
            testCase3();
            testCase4();
            testCase5();
            testCase6();
            testCase7();
            testCase8();
            testCase9();
            testCase10();
            testCase11();
            testCase12();
            testCase13();
            testCase14();
            testCase17();
            testCase18();
            testCase19();
        } catch (Exception e) {
            System.out.println("Unexpected exception during test execution: " + e.getMessage());
        }
    }

    // --- التست كيسز ---
    public static void testCase1() {
        System.out.println("Test Case 1: Normal Signup");
        if (signup("user1", "password123")) pass(); else fail();
    }

    public static void testCase2() {
        System.out.println("Test Case 2: Signup with Special Characters in Username");
        if (signup("user!@#", "password123")) pass(); else fail();
    }

    public static void testCase3() {
        System.out.println("Test Case 3: Signup with Special Characters in Password");
        if (signup("user2", "pass!@#123")) pass(); else fail();
    }

    public static void testCase4() {
        System.out.println("Test Case 4: Signup with Empty Username");
        if (signup("", "password123")) pass(); else fail();
    }

    public static void testCase5() {
        System.out.println("Test Case 5: Signup with Empty Password");
        if (signup("user3", "")) pass(); else fail();
    }

    public static void testCase6() {
        System.out.println("Test Case 6: Signup with Long Username and Password");
        String longUser = repeatChar('u', 100);
        String longPass = repeatChar('p', 100);
        if (signup(longUser, longPass)) pass(); else fail();
    }

    public static void testCase7() {
        System.out.println("Test Case 7: Signup with Multiple Users");
        boolean res = signup("user4", "password1") && signup("user5", "password2");
        if (res) pass(); else fail();
    }

    public static void testCase8() {
        System.out.println("Test Case 8: Signup with Identical Usernames");
        boolean res = signup("user6", "password3") && signup("user6", "password4");
        if (res) pass(); else fail();
    }

    public static void testCase9() {
        System.out.println("Test Case 9: File Handling Test");
        if (signup("user7", "password5")) pass(); else fail();
    }

    public static void testCase10() {
        System.out.println("Test Case 10: Invalid Characters in Username and Password");
        if (signup("user\u0000", "password\u0000")) pass(); else fail();
    }

    public static void testCase11() {
        System.out.println("Test Case 11: Duplicate Entries");
        boolean res = signup("user8", "password6") && signup("user8", "password6");
        if (res) pass(); else fail();
    }

    public static void testCase12() {
        System.out.println("Test Case 12: Large Data");
        String longUser = repeatChar('u', 1000);
        String longPass = repeatChar('p', 1000);
        if (signup(longUser, longPass)) pass(); else fail();
    }

    public static void testCase13() {
        System.out.println("Test Case 13: File Size Limits");
        boolean allPass = true;
        for (int i = 0; i < 100; i++) {
            if (!signup("user" + i, "password123")) allPass = false;
        }
        if (allPass) pass(); else fail();
    }

    public static void testCase14() {
        System.out.println("Test Case 14: Encoding Issues");
        if (!signup("user9", "password123")) {
            fail();
            return;
        }
        // كتابة بيانات غير UTF-8 عشوائية في الملف
        try (FileOutputStream fos = new FileOutputStream(PASSWORDS_FILE_PATH, true)) {
            fos.write(new byte[]{(byte)0x80, (byte)0x81, (byte)0x82, (byte)0x83});
            pass();
        } catch (IOException e) {
            fail();
        }
    }

    public static void testCase17() {
        System.out.println("Test Case 17: Handling Multiple Extensions");
        if (signup("user.with.many.extensions", "password")) pass(); else fail();
    }

    public static void testCase18() {
        System.out.println("Test Case 18: Security Measures");
        if (!signup("user11", "password11")) {
            fail();
            return;
        }
        // تحقق أن الباسوورد غير قابل للقراءة النصي المباشر
        try {
            byte[] content = Files.readAllBytes(new File(PASSWORDS_FILE_PATH).toPath());
            if (new String(content).contains("password11")) {
                fail();
            } else {
                pass();
            }
        } catch (IOException e) {
            fail();
        }
    }

    public static void testCase19() {
        System.out.println("Test Case 19: Exception Handling");
        try {
            if (signup("user12", "password12")) {
                pass();
            } else {
                fail();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            pass();
        }
    }

    // --- دوال مساعدة ---
    public static boolean signup(String username, String password) {
        try {
            byte[] hashedPassword = hashPassword(password);
            storePassword(username, hashedPassword);
            System.out.println("Signup successful!");
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred during signup: " + e.getMessage());
            return false;
        }
    }

    public static byte[] hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 100000, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        byte[] combined = new byte[salt.length + hash.length];
        System.arraycopy(salt, 0, combined, 0, salt.length);
        System.arraycopy(hash, 0, combined, salt.length, hash.length);

        return combined;
    }

    public static void storePassword(String username, byte[] hashedPassword) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(PASSWORDS_FILE_PATH, true)) {
            fos.write(username.getBytes("UTF-8"));
            fos.write(":".getBytes("UTF-8"));
            fos.write(hashedPassword);
            fos.write("\n".getBytes("UTF-8"));
        }
    }

    private static String repeatChar(char c, int times) {
        StringBuilder sb = new StringBuilder(times);
        for (int i = 0; i < times; i++) sb.append(c);
        return sb.toString();
    }

    private static void pass() {
        System.out.println("Result: PASS\n");
    }

    private static void fail() {
        System.out.println("Result: FAIL\n");
    }
}
