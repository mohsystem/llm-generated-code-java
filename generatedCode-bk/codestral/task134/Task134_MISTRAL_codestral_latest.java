package codestral.task134;// Java
import java.util.HashMap;
import java.util.Map;

public class Task134_MISTRAL_codestral_latest {
    private Map<String, String> keys;

    public Task134_MISTRAL_codestral_latest() {
        keys = new HashMap<>();
    }

    public void addKey(String keyName, String keyValue) {
        keys.put(keyName, keyValue);
    }

    public String getKey(String keyName) {
        return keys.get(keyName);
    }

    public void removeKey(String keyName) {
        keys.remove(keyName);
    }
}