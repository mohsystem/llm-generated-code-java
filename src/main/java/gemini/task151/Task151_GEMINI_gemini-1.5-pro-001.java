package gemini.task151;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insert(root, data);
    }

    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    void delete(int data) {
        root = delete(root, data);
    }

    Node delete(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    boolean search(int data) {
        return search(root, data);
    }

    boolean search(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        }
        if (data < node.data) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }

    void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Level Order Traversal: ");
        tree.levelOrderTraversal();
        System.out.println("");

        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 100: " + tree.search(100));

        System.out.println("Delete 20");
        tree.delete(20);
        System.out.println("Level Order Traversal: ");
        tree.levelOrderTraversal();
        System.out.println("");

        System.out.println("Delete 50");
        tree.delete(50);
        System.out.println("Level Order Traversal: ");
        tree.levelOrderTraversal();
        System.out.println("");
    }
}