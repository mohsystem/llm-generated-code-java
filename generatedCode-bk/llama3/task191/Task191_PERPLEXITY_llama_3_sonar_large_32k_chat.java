package llama3.task191;

public class Task191_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public int longestValidParentheses(String s) {
        int max = 0;
        int lastInvalid = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastInvalid = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - lastInvalid);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}