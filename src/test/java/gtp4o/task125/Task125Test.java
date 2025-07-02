package gtp4o.task125;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task125Test {

    @Test
    public void testAdminAccess() {
        String result = Task125_OPENAI_gpt_4o.accessResource("admin");
        assertEquals("Access to administrative resources granted.", result);
    }

    @Test
    public void testUserAccess() {
        String result = Task125_OPENAI_gpt_4o.accessResource("user");
        assertEquals("Access to user resources granted.", result);
    }

    @Test
    public void testGuestAccess() {
        String result = Task125_OPENAI_gpt_4o.accessResource("guest");
        assertEquals("Access to guest resources granted.", result);
    }

    @Test
    public void testInvalidRole() {
        String result = Task125_OPENAI_gpt_4o.accessResource("developer");
        assertEquals("No resources available for this user role", result);
    }

    @Test
    public void testEmptyRole() {
        String result = Task125_OPENAI_gpt_4o.accessResource("");
        assertEquals("No resources available for this user role", result);
    }

    @Test
    public void testCaseInsensitiveInput() {
        String result = Task125_OPENAI_gpt_4o.accessResource("ADMIN".toLowerCase());
        assertEquals("Access to administrative resources granted.", result);
    }
}
