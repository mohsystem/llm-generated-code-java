package claude2.task34;

public class Task34_CLAUDE_claude_3_5_sonnet_20240620 {
    public static boolean isNarcissistic(int number) {
        String numStr = String.valueOf(number);
        int length = numStr.length();
        int sum = 0;
        
        for (char digit : numStr.toCharArray()) {
            sum += Math.pow(Character.getNumericValue(digit), length);
        }
        
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(1652)); // false
    }
}
