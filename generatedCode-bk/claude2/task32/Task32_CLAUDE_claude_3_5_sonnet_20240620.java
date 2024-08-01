package claude2.task32;

public class Task32_CLAUDE_claude_3_5_sonnet_20240620 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int years = 0;
        while (principal < desired) {
            double interestEarned = principal * interest;
            double taxPaid = interestEarned * tax;
            principal += interestEarned - taxPaid;
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        System.out.println(calculateYears(1000, 0.05, 0.18, 1100));
    }
}
