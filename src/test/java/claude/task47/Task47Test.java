package claude.task47;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task47Test {

    private Connection conn;
    private List<String> testData;

    @BeforeEach
    void setUp() throws SQLException {
         conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        testData = List.of("Paragraph 1", "Paragraph 2", "Paragraph 3");
    }

    @AfterEach
    void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    void testScrapeWebsiteMockedHtml() throws Exception {
         String fakeHtml = """
            <html>
                <body>
                    <p>Paragraph 1</p>
                    <p>Paragraph 2</p>
                    <p>Paragraph 3</p>
                </body>
            </html>
        """;

        Document doc = Jsoup.parse(fakeHtml);
        Elements paragraphs = doc.select("p");
        List<String> data = new ArrayList<>();
        for (Element paragraph : paragraphs) {
            data.add(paragraph.text());
        }

        assertEquals(testData, data);
    }

    @Test
    void testStoreInDatabase() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS scraped_text (id INTEGER PRIMARY KEY, content TEXT)");

        String sql = "INSERT INTO scraped_text (content) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (String item : testData) {
            pstmt.setString(1, item);
            pstmt.executeUpdate();
        }

         ResultSet rs = conn.createStatement().executeQuery("SELECT content FROM scraped_text");
        List<String> storedData = new ArrayList<>();
        while (rs.next()) {
            storedData.add(rs.getString("content"));
        }

        assertEquals(testData, storedData);
    }
}
