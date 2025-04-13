package gtp4o.task50;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task50Test {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final String FILE_NAME = "testFile.txt";
    private static final String FILE_CONTENT = "This is a test file.";
    private static final String UPLOAD_DIR = "uploads/";

    private static Thread serverThread;

    @BeforeAll
    public static void startServer() {
        serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("🟢 Server started on port " + PORT);

                while (true) {
                    Socket clientSocket = serverSocket.accept();

                    try (
                            InputStream inputStream = clientSocket.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
                    ) {
                        String fileName = reader.readLine();
                        if (fileName == null || fileName.trim().isEmpty()) {
                            writer.println("❌ Invalid file name");
                            clientSocket.close();
                            continue;
                        }

                        long fileSize = Long.parseLong(reader.readLine());

                        File dir = new File(UPLOAD_DIR);
                        if (!dir.exists()) dir.mkdir();

                        File uploadedFile = new File(UPLOAD_DIR + fileName);
                        try (FileOutputStream fileOut = new FileOutputStream(uploadedFile)) {
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            long totalRead = 0;

                            while (totalRead < fileSize && (bytesRead = inputStream.read(buffer)) != -1) {
                                fileOut.write(buffer, 0, bytesRead);
                                totalRead += bytesRead;
                            }
                        }

                        writer.println("✅ File uploaded successfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        clientSocket.close();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(500); // إعطاء وقت للسيرفر يشتغل
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void cleanupBeforeTest() {
        File file = new File(UPLOAD_DIR + FILE_NAME);
        if (file.exists()) file.delete();
    }

    @Test
    @Order(1)
    public void testFileUploadSuccess() throws IOException {
        try (Socket socket = new Socket(HOST, PORT)) {
            byte[] fileBytes = FILE_CONTENT.getBytes();
            long fileSize = fileBytes.length;

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(FILE_NAME);
            writer.println(fileSize);
            out.write(fileBytes);
            out.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = reader.readLine();

            assertEquals("✅ File uploaded successfully", response);
        }

        File uploadedFile = new File(UPLOAD_DIR + FILE_NAME);
        assertTrue(uploadedFile.exists(), "File was not saved to upload directory");

        String savedContent = new String(java.nio.file.Files.readAllBytes(uploadedFile.toPath()));
        assertEquals(FILE_CONTENT, savedContent, "Uploaded file content mismatch");
    }

    @Test
    @Order(2)
    public void testEmptyFileName() throws IOException {
        try (Socket socket = new Socket(HOST, PORT)) {
            byte[] fileBytes = FILE_CONTENT.getBytes();

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(""); // Empty file name
            writer.println(fileBytes.length);
            out.write(fileBytes);
            out.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = reader.readLine();

            assertEquals("❌ Invalid file name", response);
        }

        File uploadedFile = new File(UPLOAD_DIR + FILE_NAME);
        assertFalse(uploadedFile.exists(), "File should not be created for empty name");
    }
}
