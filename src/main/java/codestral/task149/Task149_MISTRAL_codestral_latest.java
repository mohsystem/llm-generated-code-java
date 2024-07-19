package codestral.task149;

import java.util.LinkedList;
import java.util.Queue;

public class Task149_MISTRAL_codestral_latest {
    private Queue<Integer> queue = new LinkedList<>();

    public void enqueue(int item) {
        queue.add(item);
    }

    public Integer dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public Integer peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.peek();
    }
}