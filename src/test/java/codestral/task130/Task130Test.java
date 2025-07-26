package codestral.task130;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DummyApiController.class)
@Import(Task130_MISTRAL_codestral_latest.class) // 👈 نستورد CORS config فقط
public class Task130Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCorsAllowedOriginHeader() throws Exception {
        mockMvc.perform(get("/api")
                        .header(HttpHeaders.ORIGIN, "http://example.com"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "http://example.com"));
    }

    @Test
    void testCorsPreflightRequest() throws Exception {
        mockMvc.perform(options("/api")
                        .header(HttpHeaders.ORIGIN, "http://example.com")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "http://example.com"))
                .andExpect(header().exists("Access-Control-Allow-Methods"));
    }
}
