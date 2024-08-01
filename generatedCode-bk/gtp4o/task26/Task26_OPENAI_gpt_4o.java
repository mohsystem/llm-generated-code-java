package gtp4o.task26;

public class Task26_OPENAI_gpt_4o {
    public static void main(String[] args) {
        int[] array = {1,2,2,3,3,3,4,3,3,3,2,2,1};
        int result = findOdd(array);
        System.out.println(result);
    }

    public static int findOdd(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }
}