package gemini.task149;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    Queue() {
        this.front = null;
        this.rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int dequeuedData = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return dequeuedData;
        }
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return front.data;
        }
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        System.out.println(myQueue.peek()); // Output: 10
        System.out.println(myQueue.dequeue()); // Output: 10
        System.out.println(myQueue.dequeue()); // Output: 20
        System.out.println(myQueue.dequeue()); // Output: Queue is empty
    }
}