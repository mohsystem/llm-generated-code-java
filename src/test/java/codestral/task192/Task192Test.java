package codestral.task192;

public class Task192Test {

    private final Task192_MISTRAL_codestral_latest solution = new Task192_MISTRAL_codestral_latest();

    public void test_example1() {
        int[] nums = {1, 1, 2};
        boolean result = solution.xorGame(nums);
        // Expected false from Python code, but your code returns differently.
        if (result == false) {
            System.out.println("test_example1: PASS");
        } else {
            System.out.println("test_example1: FAIL");
        }
    }

    public void test_example2() {
        int[] nums = {0, 1};
        boolean result = solution.xorGame(nums);
        // Expected true from Python code
        if (result == true) {
            System.out.println("test_example2: PASS");
        } else {
            System.out.println("test_example2: FAIL");
        }
    }

    public void test_example3() {
        int[] nums = {1, 2, 3};
        boolean result = solution.xorGame(nums);
        // Expected true from Python code
        if (result == true) {
            System.out.println("test_example3: PASS");
        } else {
            System.out.println("test_example3: FAIL");
        }
    }

    public static void main(String[] args) {
        Task192Test test = new Task192Test();

        test.test_example1();
        test.test_example2();
        test.test_example3();
    }
}
