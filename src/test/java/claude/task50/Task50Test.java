package claude.task50;

import org.junit.jupiter.api.*;

import java.io.*;
import java.net.*;

import static org.junit.jupiter.api.Assertions.*;

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
                System.out.println("Server started on port " + PORT);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    InputStream inputStream = clientSocket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    String fileName = reader.readLine();
                    long fileSize = Long.parseLong(reader.readLine());

                    File dir = new File(UPLOAD_DIR);
                    if (!dir.exists()) dir.mkdir();

                    FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + fileName);
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long totalBytesRead = 0;

                    while (totalBytesRead < fileSize && (bytesRead = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                        totalBytesRead += bytesRead;
                    }

                    fileOutputStream.close();

                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println("File uploaded successfully");

                    clientSocket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

         try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void setup() {
        File uploadedFile = new File(UPLOAD_DIR + FILE_NAME);
        if (uploadedFile.exists()) {
            uploadedFile.delete();
        }
    }

    @Test
    public void testFileUpload() throws IOException {
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

            assertEquals("File uploaded successfully", response);
        }

        File uploadedFile = new File(UPLOAD_DIR + FILE_NAME);
        assertTrue(uploadedFile.exists(), "The file was not uploaded");

        String savedContent = new String(java.nio.file.Files.readAllBytes(uploadedFile.toPath()));
        assertEquals(FILE_CONTENT, savedContent, "File content does not match");
    }
}
