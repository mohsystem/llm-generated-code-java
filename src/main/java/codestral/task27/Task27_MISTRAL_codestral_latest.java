package codestral.task27;

public class Task27_MISTRAL_codestral_latest {
    public static int find(int[] integers){
        int evenCount = 0, oddCount = 0;
        int even = 0, odd = 0;
        for(int i = 0; i < integers.length; i++){
            if(integers[i] % 2 == 0){
                evenCount++;
                even = integers[i];
            } else {
                oddCount++;
                odd = integers[i];
            }
        }
        return evenCount < oddCount ? even : odd;
    }
}