package claude.task23;

public class Task23_CLAUDE_claude_3_5_sonnet_20240620 {
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
