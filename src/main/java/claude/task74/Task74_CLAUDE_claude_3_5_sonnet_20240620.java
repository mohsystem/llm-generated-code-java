package claude.task74;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74_CLAUDE_claude_3_5_sonnet_20240620 {
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/your_database";
        String user = "your_username";
        String password = "your_password";
        
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to the database!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
