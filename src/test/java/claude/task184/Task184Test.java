package claude.task184;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Task184Test {

    private Set<String> usedNames;

    @BeforeEach
    public void setUp() {
        usedNames = new HashSet<>();
    }

    @Test
    public void testNameIsUnique() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        String name = robot.getName();
        assertTrue(usedNames.add(name), "Name collision detected");
    }

    @Test
    public void testResetGeneratesNewName() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        String initialName = robot.getName();
        robot.reset();
        String newName = robot.getName();
        assertNotEquals(initialName, newName, "Reset did not generate a new name");
    }

    @Test
    public void testGeneratedNameIsUnique() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot1 = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot2 = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        String name1 = robot1.getName();
        String name2 = robot2.getName();
        assertNotEquals(name1, name2, "Generated names are not unique");
    }

    @Test
    public void testGeneratedNameFormat() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        String name = robot.getName();
        assertTrue(name.matches("[A-Z]{2}\\d{3}"), "Generated name does not match the required format");
    }

    @Test
    public void testResetClearsUsedName() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        String initialName = robot.getName();
        usedNames.add(initialName);
        robot.reset();
        String newName = robot.getName();
        assertTrue(!usedNames.contains(newName), "Reset did not clear used names correctly");
    }

    @Test
    public void testMultipleResetsGenerateUniqueNames() {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
            robot.reset();
            String name = robot.getName();
            assertTrue(names.add(name), "Name collision detected during multiple resets");
        }
    }

    @Test
    public void testNameFormatAfterMultipleResets() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        for (int i = 0; i < 10; i++) {
            robot.reset();
            String name = robot.getName();
            assertTrue(name.matches("[A-Z]{2}\\d{3}"), "Generated name does not match the required format after multiple resets");
        }
    }

    @Test
    public void testNoCollisionAfterLongRun() {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
            String name = robot.getName();
            assertTrue(names.add(name), "Name collision detected during long run");
        }
    }

    // New Test Cases
    @Test
    public void testNameRemainsUniqueOverMultipleInstances() {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
            String name = robot.getName();
            assertTrue(names.add(name), "Name collision detected over multiple instances");
        }
    }

    @Test
    public void testResetGeneratesUniqueNameEveryTime() {
        Task184_CLAUDE_claude_3_5_sonnet_20240620 robot = new Task184_CLAUDE_claude_3_5_sonnet_20240620();
        String initialName = robot.getName();
        for (int i = 0; i < 100; i++) {
            robot.reset();
            String newName = robot.getName();
            assertNotEquals(initialName, newName, "Reset did not generate a unique name");
            initialName = newName;
        }
    }
}
