package llama3.task5;

public class Task5_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static int persistence(long n) {
        int count = 0;
        while (n >= 10) {
            long mult = 1;
            while (n > 0) {
                mult *= n % 10;
                n /= 10;
            }
            n = mult;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(persistence(39));  // 3
        System.out.println(persistence(999)); // 4
        System.out.println(persistence(4));   // 0
    }
}