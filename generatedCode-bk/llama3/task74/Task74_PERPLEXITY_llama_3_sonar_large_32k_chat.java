package llama3.task74;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "username", "password");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to the database.");
        }
    }
}