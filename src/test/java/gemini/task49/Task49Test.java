package gemini.task49;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task49Test {

    private static Thread serverThread;

    // تأكد من أن السيرفر يبدأ قبل تشغيل أي اختبار
    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try {
                Task49_GEMINI_gemini_1_5_pro_001.main(null); // تشغيل السيرفر
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        serverThread.start();
        try {
            Thread.sleep(3000); // الانتظار قليلاً لتأكد من بدء الخادم بشكل كامل
        } catch (InterruptedException ignored) {}
    }


    // اختبار إضافة مستخدم جديد
    @Test
    public void testCreateUser_returnsCorrectJsonAndStatus() throws IOException {
        // إنشاء اتصال مع الـ API
        URL url = new URL("http://localhost:8080/api/add_user");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // البيانات التي سيتم إرسالها
        String jsonInput = "{\"name\":\"John Doe\", \"email\":\"john.doe2@example.com\"}";

        // إرسال البيانات إلى السيرفر
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes();
            os.write(input);
        }

        // التحقق من حالة الاستجابة
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode);

        // قراءة الاستجابة من السيرفر
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        String response = responseBody.toString();

        // التحقق من أن البيانات المدخلة في الاستجابة
        assertTrue(response.contains("\"name\":\"John Doe\""));
        assertTrue(response.contains("\"email\":\"john.doe2@example.com\""));
        assertTrue(response.contains("\"id\"")); // التأكد من وجود الـ ID في الاستجابة

        connection.disconnect();
    }

    // اختبار حالة البريد الإلكتروني الموجود مسبقاً
    @Test
    public void testEmailAlreadyExists() throws IOException {
        // إرسال نفس البريد الإلكتروني مرة أخرى
        URL url = new URL("http://localhost:8080/api/add_user");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String jsonInput = "{\"name\":\"John Doe\", \"email\":\"john.doe2@example.com\"}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes();
            os.write(input);
        }

        int statusCode = connection.getResponseCode();
        assertEquals(400, statusCode); // يجب أن يكون الاستجابة 400 إذا كان البريد الإلكتروني موجوداً بالفعل

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBody.append(line);
        }
        reader.close();

        String response = responseBody.toString();

        // التحقق من أن الرسالة التي تحتوي على "Email already exists" موجودة في الاستجابة
        assertTrue(response.contains("Email already exists"));

        connection.disconnect();
    }

    // تأكد من إيقاف السيرفر بعد الانتهاء من الاختبارات
    @AfterAll
    public static void stopServer() {
        // إيقاف السيرفر بعد الانتهاء من الاختبارات
        serverThread.interrupt();
    }
}
