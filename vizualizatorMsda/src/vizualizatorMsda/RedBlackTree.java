package vizualizatorMsda;
import java.util.ArrayList;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left;
        Node right;
        boolean color;

        public Node(int key) {
            this.key = key;
            this.color = RED;
        }
    }

    private Node root;

    public void add(int key) {
        root = add(root, key);
        root.color = BLACK;
    }

    private Node add(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = add(node.left, key);
        } else if (key > node.key) {
            node.right = add(node.right, key);
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void printTree() {
        ArrayList<Node> currentLevel = new ArrayList<>();
        ArrayList<Node> nextLevel = new ArrayList<>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            for (Node node : currentLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                System.out.print((node.color == RED ? "R" : "B") + " " + node.key + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
        }
    }
}

