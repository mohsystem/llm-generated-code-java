package claude.task149;

import java.util.LinkedList;

public class Task149_CLAUDE_claude_3_5_sonnet_20240620<T> {
    private LinkedList<T> items;

    public Task149_CLAUDE_claude_3_5_sonnet_20240620() {
        items = new LinkedList<>();
    }

    public void enqueue(T item) {
        items.addLast(item);
    }

    public T dequeue() {
        if (!isEmpty()) {
            return items.removeFirst();
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return items.getFirst();
        }
        return null;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public static void main(String[] args) {
        Task149_CLAUDE_claude_3_5_sonnet_20240620<Integer> q = new Task149_CLAUDE_claude_3_5_sonnet_20240620<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek());  // Output: 1
        System.out.println(q.dequeue());  // Output: 1
        System.out.println(q.size());  // Output: 2
    }
}
