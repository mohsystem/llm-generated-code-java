package gtp4o.task47;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task47Test {

    private final List<String> expectedData = List.of("Apple", "Banana", "Cherry");

    @Test
    void testScrapeDataWithMockHtml() throws Exception {
        String html = """
            <html>
              <body>
                <ul>
                  <li>Apple</li>
                  <li>Banana</li>
                  <li>Cherry</li>
                </ul>
              </body>
            </html>
        """;

         List<String> actualData = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements items = doc.select("li");
        for (Element item : items) {
            actualData.add(item.text());
        }

        assertEquals(expectedData, actualData);
    }

    @Test
    void testStoreData() throws Exception {
        // قاعدة بيانات داخلية
        String dbUrl = "jdbc:sqlite::memory:";
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS scraped_data (content TEXT)");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO scraped_data (content) VALUES (?)");
            for (String item : expectedData) {
                pstmt.setString(1, item);
                pstmt.executeUpdate();
            }

             ResultSet rs = conn.createStatement().executeQuery("SELECT content FROM scraped_data");
            List<String> actualData = new ArrayList<>();
            while (rs.next()) {
                actualData.add(rs.getString("content"));
            }

            assertEquals(expectedData, actualData);
        }
    }
}
