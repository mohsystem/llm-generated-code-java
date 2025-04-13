package codestral.task47;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task47Test {

    private Connection conn;
    private final List<Map.Entry<String, String>> expectedData = List.of(
            Map.entry("Item 1", "https://link1.com"),
            Map.entry("Item 2", "https://link2.com"),
            Map.entry("Item 3", "https://link3.com")
    );

    @BeforeEach
    void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        String sql = "CREATE TABLE IF NOT EXISTS data (title TEXT, link TEXT)";
        conn.prepareStatement(sql).executeUpdate();
    }

    @AfterEach
    void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    void testScrapeAndStoreData() throws Exception {
        String mockHtml = """
            <html>
              <body>
                <div class="item">
                  <h2>Item 1</h2>
                  <a href="https://link1.com">Link</a>
                </div>
                <div class="item">
                  <h2>Item 2</h2>
                  <a href="https://link2.com">Link</a>
                </div>
                <div class="item">
                  <h2>Item 3</h2>
                  <a href="https://link3.com">Link</a>
                </div>
              </body>
            </html>
        """;

         Document doc = Jsoup.parse(mockHtml);
        Elements items = doc.select("div.item");

        String insertSQL = "INSERT INTO data(title, link) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        for (Element item : items) {
            String title = item.select("h2").text();
            String link = item.select("a").attr("href");

            pstmt.setString(1, title);
            pstmt.setString(2, link);
            pstmt.executeUpdate();
        }

         ResultSet rs = conn.createStatement().executeQuery("SELECT title, link FROM data");
        List<Map.Entry<String, String>> actualData = new ArrayList<>();

        while (rs.next()) {
            actualData.add(Map.entry(rs.getString("title"), rs.getString("link")));
        }

        assertEquals(expectedData, actualData);
    }
}
