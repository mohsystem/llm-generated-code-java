package gemini.task160;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Task160_GEMINI_gemini_1_5_pro_001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String urlString = scanner.nextLine();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner sc = new Scanner(connection.getInputStream());
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}