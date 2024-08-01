package codestral.task9;

public class Task9_MISTRAL_codestral_latest {
    public static String oddOrEven(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        int[] array = {0, -1, -5};
        System.out.println(oddOrEven(array));
    }
}