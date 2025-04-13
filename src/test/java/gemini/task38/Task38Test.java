package gemini.task38;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Task38_GEMINI_gemini_1_5_pro_001.class)
class Task38Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPostWithInput() throws Exception {
        mockMvc.perform(post("/submit")
                        .param("userInput", "Alice"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("userInput", "Alice"))
                .andExpect(view().name("index"));
    }

    @Test
    void testPostWithEmptyInput() throws Exception {
        mockMvc.perform(post("/submit")
                        .param("userInput", ""))
                .andExpect(status().isOk())
                .andExpect(model().attribute("userInput", ""))
                .andExpect(view().name("index"));
    }

    @Test
    void testPostWithNullInput() throws Exception {
        mockMvc.perform(post("/submit"))
                .andExpect(status().isBadRequest());
    }
}
