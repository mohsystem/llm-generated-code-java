package gemini.task47;

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
    private final List<String> expectedData = List.of("Data A", "Data B", "Data C");

    @BeforeEach
    void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        String createSQL = "CREATE TABLE IF NOT EXISTS scraped_data (id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT)";
        conn.prepareStatement(createSQL).executeUpdate();
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
                <div class="example-class">Data A</div>
                <div class="example-class">Data B</div>
                <div class="example-class">Data C</div>
              </body>
            </html>
        """;

        Document doc = Jsoup.parse(mockHtml);
        Elements dataElements = doc.select("div.example-class");

        String insertSQL = "INSERT INTO scraped_data (data) VALUES (?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertSQL);

        for (Element element : dataElements) {
            String data = element.text().trim();
            insertStmt.setString(1, data);
            insertStmt.executeUpdate();
        }

         ResultSet rs = conn.createStatement().executeQuery("SELECT data FROM scraped_data");
        List<String> actualData = new ArrayList<>();
        while (rs.next()) {
            actualData.add(rs.getString("data"));
        }

        assertEquals(expectedData, actualData);
    }
}
