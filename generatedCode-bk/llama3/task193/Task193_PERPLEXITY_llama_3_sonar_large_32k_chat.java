package llama3.task193;

public class Task193_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public boolean xorGame(int[] nums) {
        int xor_all = 0;
        int count = 0;
        for (int num : nums) {
            xor_all ^= num;
            if (num % 2 == 0) {
                count++;
            }
        }
        return xor_all == 0 || count % 2 == 1;
    }
}