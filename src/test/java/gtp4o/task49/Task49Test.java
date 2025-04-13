package gtp4o.task49;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import javax.sql.DataSource;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task49Test {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @LocalServerPort
    private int port;

    private String getUrl() {
        return "http://localhost:" + port + "/api/add_user";
    }

    @BeforeEach
    public void setupDatabase() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
        jdbcTemplate.execute("CREATE TABLE users (id SERIAL, name VARCHAR(255), email VARCHAR(255) UNIQUE)");
    }

    @Test
    @Order(1)
    public void testCreateUserSuccess() {
        Map<String, String> userData = Map.of(
                "name", "John Doe",
                "email", "john.doe2@example.com"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(userData, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(getUrl(), request, String.class);

        assertEquals(200, response.getStatusCodeValue(), "Status code should be 200");
        assertTrue(response.getBody().contains("User added successfully!"), "Response should confirm user creation");
    }

    // ✅ Optional: تأكد من منع التكرار
    @Test
    @Order(2)
    public void testDuplicateEmailFails() {
        Map<String, String> userData = Map.of(
                "name", "Jane Doe",
                "email", "john.doe2@example.com"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(userData, headers);

        // أول مرة تنجح
        restTemplate.postForEntity(getUrl(), request, String.class);
        // ثاني مرة لازم تفشل
        ResponseEntity<String> response = restTemplate.postForEntity(getUrl(), request, String.class);

        assertTrue(response.getStatusCode().is4xxClientError(), "Duplicate email should return 4xx error");
    }

    // ✅ Optional: تهيئة سيرفر H2 مؤقت
    @TestConfiguration
    static class H2ServerConfig {
        @Bean(initMethod = "start", destroyMethod = "stop")
        public Server inMemoryH2DatabaseServer() throws SQLException {
            return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        }
    }
}
