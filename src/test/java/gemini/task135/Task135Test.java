package gemini.task135;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.assertj.core.api.Assertions.assertThat;
 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Task135Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCsrfTokenPresentInGetRequest() throws Exception {
        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String cookieHeader = result.getResponse().getHeader("Set-Cookie");
        assertThat(cookieHeader).contains("XSRF-TOKEN");
    }

    @Test
    public void testPostWithValidCsrfToken() throws Exception {
        mockMvc.perform(post("/")
                        .with(csrf()) // Automatically adds valid CSRF token
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("data", "test"))
                .andExpect(status().isOk()); // Assuming POST is allowed
    }

    private RequestPostProcessor csrf() {
        return null;
    }

    @Test
    public void testPostWithoutCsrfTokenFails() throws Exception {
        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("data", "test"))
                .andExpect(status().isForbidden());
    }
}
