package llama3.task27;

public class Task27_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static int findOutlier(int[] integers) {
        int evenCount = 0;
        int oddCount = 0;
        int evenNum = 0;
        int oddNum = 0;
        
        for (int i : integers) {
            if (i % 2 == 0) {
                evenCount++;
                evenNum = i;
            } else {
                oddCount++;
                oddNum = i;
            }
        }
        
        return evenCount == 1 ? evenNum : oddNum;
    }

    public static void main(String[] args) {
        int[] integers = {2, 4, 0, 100, 4, 11, 2602, 36};
        System.out.println(findOutlier(integers));
    }
}