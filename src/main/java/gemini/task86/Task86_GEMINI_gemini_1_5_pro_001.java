package gemini.task86;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.*;

public class Task86_GEMINI_gemini_1_5_pro_001 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please provide a URL as an argument.");
            return;
        }

        String urlStr = args[0];
        String fileName = urlStr.substring(urlStr.lastIndexOf('/') + 1);

        try {
            downloadFile(urlStr, fileName);
            runExe(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadFile(String urlStr, String fileName) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    private static void runExe(String fileName) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(fileName);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}