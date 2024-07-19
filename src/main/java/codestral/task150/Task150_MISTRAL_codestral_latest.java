package codestral.task150;

public class Task150_MISTRAL_codestral_latest {
    int data;
    Task150_MISTRAL_codestral_latest next;

    Task150_MISTRAL_codestral_latest(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Task150_MISTRAL_codestral_latest head;

    public void insert(int data) {
        if (head == null) {
            head = new Task150_MISTRAL_codestral_latest(data);
        } else {
            Task150_MISTRAL_codestral_latest cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Task150_MISTRAL_codestral_latest(data);
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Task150_MISTRAL_codestral_latest cur = head;
        while (cur.next != null) {
            if (cur.next.data == data) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    public boolean search(int data) {
        Task150_MISTRAL_codestral_latest cur = head;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}