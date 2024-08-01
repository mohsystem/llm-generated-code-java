package gtp4o.task147;

public class Task147_OPENAI_gpt_4o {
    static {
        System.loadLibrary("shared");
    }

    private native int findKthLargest(int[] arr, int n, int k);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = scanner.nextInt();
        scanner.close();

        Task147_OPENAI_gpt_4o main = new Task147_OPENAI_gpt_4o();
        int result = main.findKthLargest(arr, arr.length, k);
        System.out.println(result);
    }
}