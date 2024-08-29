package llama3.task184;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Task184Test {

    private Set<String> usedNames;

    @BeforeEach
    public void setUp() {
        usedNames = new HashSet<>();
    }

    private String getName(Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot) throws NoSuchFieldException, IllegalAccessException {
        Field nameField = Task184_PERPLEXITY_llama_3_sonar_large_32k_chat.class.getDeclaredField("name");
        nameField.setAccessible(true);
        return (String) nameField.get(robot);
    }

    @Test
    public void testNameIsUniqueOnCreation() throws NoSuchFieldException, IllegalAccessException {
        Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
        String name = getName(robot);
        assertTrue(usedNames.add(name), "Name collision detected on creation");
    }

    @Test
    public void testNameFormat() throws NoSuchFieldException, IllegalAccessException {
        Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
        String name = getName(robot);
        assertTrue(name.matches("[A-Z]{2}\\d{3}"), "Generated name does not match the required format");
    }

    @Test
    public void testResetGeneratesNewName() throws NoSuchFieldException, IllegalAccessException {
        Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
        String initialName = getName(robot);
        robot.reset();
        String newName = getName(robot);
        assertNotEquals(initialName, newName, "Reset did not generate a new name");
    }

    @Test
    public void testGeneratedNameIsUnique() throws NoSuchFieldException, IllegalAccessException {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String name = getName(robot);
            assertTrue(names.add(name), "Generated names are not unique");
        }
    }

    @Test
    public void testNameFormatAfterMultipleCreations() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 1000; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String name = getName(robot);
            assertTrue(name.matches("[A-Z]{2}\\d{3}"), "Generated name does not match the required format after multiple creations");
        }
    }

    @Test
    public void testResetGeneratesUniqueNameEveryTime() throws NoSuchFieldException, IllegalAccessException {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String initialName = getName(robot);
            robot.reset();
            String newName = getName(robot);
            assertNotEquals(initialName, newName, "Reset did not generate a unique name");
            assertTrue(names.add(newName), "Name collision detected during reset");
        }
    }

    @Test
    public void testNoCollisionOverLongRun() throws NoSuchFieldException, IllegalAccessException {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String name = getName(robot);
            assertTrue(names.add(name), "Name collision detected during long run");
        }
    }

    @Test
    public void testNameFormatAfterMultipleInstances() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 1000; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String name = getName(robot);
            assertTrue(name.matches("[A-Z]{2}\\d{3}"), "Generated name does not match the required format after multiple instances");
        }
    }

    @Test
    public void testNameUniquenessAcrossInstances() throws NoSuchFieldException, IllegalAccessException {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String name = getName(robot);
            assertTrue(names.add(name), "Name collision detected across instances");
        }
    }

    @Test
    public void testResetClearsUsedNames() throws NoSuchFieldException, IllegalAccessException {
        Set<String> usedNames = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            Task184_PERPLEXITY_llama_3_sonar_large_32k_chat robot = new Task184_PERPLEXITY_llama_3_sonar_large_32k_chat();
            String name = getName(robot);
            assertTrue(usedNames.add(name), "Name collision detected on reset");
            robot.reset();
        }
    }
}