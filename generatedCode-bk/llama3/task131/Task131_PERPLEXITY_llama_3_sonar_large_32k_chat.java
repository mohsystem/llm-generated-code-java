package llama3.task131;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Task131_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static Object deserializeData(byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            System.out.println("Error deserializing data: " + e);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter serialized data: ");
        byte[] data = System.in.readAllBytes();
        Object deserializedData = deserializeData(data);
        System.out.println("Deserialized data: " + deserializedData);
    }
}