package codestral.task130;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest // أو @SpringBootTest إذا كنت تحتاج إلى تشغيل السيرفر الكامل
public class Task130Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorsEnabledForApiEndpoint() throws Exception {
        mockMvc.perform(get("/api/data")
                        .header("Origin", "http://example.com"))
                .andExpect(status().isOk());
    }
}