package llama3.task47;

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
    private final Map<Integer, String> expectedData = Map.of(
            0, "Entry One",
            1, "Entry Two",
            2, "Entry Three"
    );

    @BeforeEach
    void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        conn.createStatement().execute("CREATE TABLE IF NOT EXISTS data (id INTEGER PRIMARY KEY, data TEXT)");
    }

    @AfterEach
    void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    void testScrapeAndStoreData() throws Exception {
        String html = """
            <html>
              <body>
                <div class="data">Entry One</div>
                <div class="data">Entry Two</div>
                <div class="data">Entry Three</div>
              </body>
            </html>
        """;

        Document doc = Jsoup.parse(html);
        Elements dataElements = doc.select("div.data");

        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO data VALUES (?, ?)");
        for (int i = 0; i < dataElements.size(); i++) {
            pstmt.setInt(1, i);
            pstmt.setString(2, dataElements.get(i).text());
            pstmt.executeUpdate();
        }

        ResultSet rs = conn.createStatement().executeQuery("SELECT id, data FROM data");
        Map<Integer, String> actualData = new LinkedHashMap<>();
        while (rs.next()) {
            actualData.put(rs.getInt("id"), rs.getString("data"));
        }

        assertEquals(expectedData, actualData);
    }
}
