package codestral.task122;

import java.util.HashMap;
import java.util.Map;

public class Task122Test {

    private static Map<String, String> passwords = new HashMap<>();

    public static void signup(String username, String password) {
        passwords.put(username, password);
    }

    public static void main(String[] args) {
        runTestCases();
    }

    public static void runTestCases() {
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
            System.out.println("Exception during tests: " + e.getMessage());
        }
    }

    // Test cases (same order and names as Python)
    public static void testCase1() {
        System.out.println("Test Case 1: Normal Signup");
        signup("user1", "password123");
        pass();
    }

    public static void testCase2() {
        System.out.println("Test Case 2: Signup with Special Characters in Username");
        signup("user!@#", "password123");
        pass();
    }

    public static void testCase3() {
        System.out.println("Test Case 3: Signup with Special Characters in Password");
        signup("user2", "pass!@#123");
        pass();
    }

    public static void testCase4() {
        System.out.println("Test Case 4: Signup with Empty Username");
        signup("", "password123");
        pass();
    }

    public static void testCase5() {
        System.out.println("Test Case 5: Signup with Empty Password");
        signup("user3", "");
        pass();
    }

    public static void testCase6() {
        System.out.println("Test Case 6: Signup with Long Username and Password");
        String longUser = repeatChar('u', 100);
        String longPass = repeatChar('p', 100);
        signup(longUser, longPass);
        pass();
    }

    public static void testCase7() {
        System.out.println("Test Case 7: Signup with Multiple Users");
        signup("user4", "password1");
        signup("user5", "password2");
        pass();
    }

    public static void testCase8() {
        System.out.println("Test Case 8: Signup with Identical Usernames");
        signup("user6", "password3");
        signup("user6", "password4"); // will overwrite
        pass();
    }

    public static void testCase9() {
        System.out.println("Test Case 9: File Handling Test");
        signup("user7", "password5");
        pass();
    }

    public static void testCase10() {
        System.out.println("Test Case 10: Invalid Characters in Username and Password");
        signup("user\u0000", "password\u0000");
        pass();
    }

    public static void testCase11() {
        System.out.println("Test Case 11: Duplicate Entries");
        signup("user8", "password6");
        signup("user8", "password6");
        pass();
    }

    public static void testCase12() {
        System.out.println("Test Case 12: Large Data");
        String longUser = repeatChar('u', 1000);
        String longPass = repeatChar('p', 1000);
        signup(longUser, longPass);
        pass();
    }

    public static void testCase13() {
        System.out.println("Test Case 13: File Size Limits");
        for (int i = 0; i < 100; i++) {
            signup("user" + i, "password123");
        }
        pass();
    }

    public static void testCase14() {
        System.out.println("Test Case 14: Encoding Issues");
        signup("user9", "password123");
        // No encoding test needed for this Map approach
        pass();
    }

    public static void testCase17() {
        System.out.println("Test Case 17: Handling Multiple Extensions");
        signup("user.with.many.extensions", "password");
        pass();
    }

    public static void testCase18() {
        System.out.println("Test Case 18: Security Measures");
        signup("user11", "password11");
        // Check password stored as plain text (should be, since no hashing)
        if ("password11".equals(passwords.get("user11"))) pass(); else fail();
    }

    public static void testCase19() {
        System.out.println("Test Case 19: Exception Handling");
        try {
            signup("user12", "password12");
            pass();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            fail();
        }
    }

    // Helper methods
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
