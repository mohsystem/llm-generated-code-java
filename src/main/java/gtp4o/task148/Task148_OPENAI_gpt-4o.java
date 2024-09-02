package gtp4o.task148;

import java.util.*;

class Stack {
    private List<Integer> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(int item) {
        stack.add(item);
    }

    public Integer pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public Integer peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.peek());  // Output: 2
    }
}