package codestral.task115;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task115Test {

    @Test
    void testConstructorAndFieldsTrue() {
        Task115_MISTRAL_codestral_latest obj = new Task115_MISTRAL_codestral_latest(true, true, true);

        assertNotNull(obj, "Object should be created successfully with all true values");
    }

    @Test
    void testConstructorAndFieldsFalse() {
        Task115_MISTRAL_codestral_latest obj = new Task115_MISTRAL_codestral_latest(false, false, false);

        assertNotNull(obj, "Object should be created successfully with all false values");
    }

    @Test
    void testMixedValues() {
        Task115_MISTRAL_codestral_latest obj1 = new Task115_MISTRAL_codestral_latest(true, false, true);
        Task115_MISTRAL_codestral_latest obj2 = new Task115_MISTRAL_codestral_latest(false, true, false);
        Task115_MISTRAL_codestral_latest obj3 = new Task115_MISTRAL_codestral_latest(false, false, true);

        assertNotNull(obj1, "Object should be created successfully with mixed values");
        assertNotNull(obj2, "Object should be created successfully with mixed values");
        assertNotNull(obj3, "Object should be created successfully with mixed values");
    }
}
