package gemini.task23;

public class Task23_GEMINI_gemini_1_5_pro_001 {
    public static long findNb(long m) {
        long n = 0;
        long sum = 0;
        while (sum < m) {
            n++;
            sum += n * n * n;
        }
        return sum == m ? n : -1;
    }
}