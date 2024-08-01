package claude2.task132;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task132_CLAUDE_claude_3_5_sonnet_20240620 {
    private static final Logger LOGGER = Logger.getLogger(Task132_CLAUDE_claude_3_5_sonnet_20240620.class.getName());

    public static void setupLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("security_events.log", true);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        LOGGER.addHandler(fileHandler);
    }

    public static void logEvent(String eventType, String description) {
        LOGGER.info("Event Type: " + eventType + ", Description: " + description);
    }

    public static void monitorEvents() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter event type (or \'q\' to quit): ");
            String eventType = scanner.nextLine();
            if (eventType.equalsIgnoreCase("q")) {
                break;
            }
            System.out.print("Enter event description: ");
            String description = scanner.nextLine();
            logEvent(eventType, description);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            setupLogger();
            System.out.println("Security Event Monitoring System");
            monitorEvents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
