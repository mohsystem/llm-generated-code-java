package gtp4o.task124;

import java.util.Base64;

public class Task124_OPENAI_gpt_4o {
    private String encodedData;
    
    public Task124_OPENAI_gpt_4o(String data) {
        this.encodedData = encodeData(data);
    }

    private String encodeData(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private String decodeData() {
        return new String(Base64.getDecoder().decode(this.encodedData));
    }

    public static void main(String[] args) {
        Task124_OPENAI_gpt_4o sd = new Task124_OPENAI_gpt_4o("4111-1111-1111-1111");
        System.out.println("Encoded Data (Java): " + sd.encodedData);
        System.out.println("Decoded Data (Java): " + sd.decodeData());
    }
}