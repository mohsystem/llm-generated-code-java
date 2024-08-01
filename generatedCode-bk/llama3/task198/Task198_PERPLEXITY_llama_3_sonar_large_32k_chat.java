package llama3.task198;

public class Task198_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) {
                return num % 10 + 1;
            }
        }
    }

    public int[] main(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rand10();
        }
        return result;
    }

    public static void main(String[] args) {
        Task198_PERPLEXITY_llama_3_sonar_large_32k_chat solution = new Task198_PERPLEXITY_llama_3_sonar_large_32k_chat();
        int n = 1;  // change this to test with different inputs
        int[] result = solution.main(n);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}