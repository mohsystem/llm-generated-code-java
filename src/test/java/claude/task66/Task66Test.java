package claude.task66;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task66Test {

    @Test
    public void testValidCommand_echo() {
        String cmd = "echo HelloWorld";
        assertTrue(Task66_CLAUDE_claude_3_5_sonnet_20240620.validateCommand(cmd));

        String output = Task66_CLAUDE_claude_3_5_sonnet_20240620.executeCommand(cmd).trim();
        assertEquals("HelloWorld", output);
    }

    @Test
    public void testValidCommand_whoami() {
        String cmd = "whoami";
        assertTrue(Task66_CLAUDE_claude_3_5_sonnet_20240620.validateCommand(cmd));

        String output = Task66_CLAUDE_claude_3_5_sonnet_20240620.executeCommand(cmd).trim();
        assertFalse(output.isEmpty());  // لأن whoami يرجع اسم المستخدم الحالي
    }

    @Test
    public void testInvalidCommand_rm() {
        String cmd = "rm -rf /";
        assertFalse(Task66_CLAUDE_claude_3_5_sonnet_20240620.validateCommand(cmd));
    }

    @Test
    public void testInvalidCommand_empty() {
        String cmd = "   ";
        assertFalse(Task66_CLAUDE_claude_3_5_sonnet_20240620.validateCommand(cmd));
    }

    @Test
    public void testCommandExecutionFailure() {
        String cmd = "invalid_command_987";
        assertTrue(Task66_CLAUDE_claude_3_5_sonnet_20240620.validateCommand(cmd));

        String output = Task66_CLAUDE_claude_3_5_sonnet_20240620.executeCommand(cmd);
        assertTrue(output.toLowerCase().contains("error") || output.isEmpty()); // حسب الرسالة
    }
}
