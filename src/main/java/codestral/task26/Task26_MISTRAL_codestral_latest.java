package codestral.task26;

public class Task26_MISTRAL_codestral_latest {
    public static int findOdd(int[] arr) {
        for (int num : arr) {
            int count = 0;
            for (int i : arr) {
                if (i == num) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return num;
            }
        }
        return -1;
    }
}