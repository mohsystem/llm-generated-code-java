package claude.task5;

public class Task5_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int persistence(long n) {
        if (n < 10) return 0;
        int count = 0;
        while (n >= 10) {
            long product = 1;
            while (n > 0) {
                product *= n % 10;
                n /= 10;
            }
            n = product;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39));  // Output: 3
        System.out.println(persistence(999)); // Output: 4
        System.out.println(persistence(4));   // Output: 0
    }
}
