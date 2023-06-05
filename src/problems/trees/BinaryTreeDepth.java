package problems.trees;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class BinaryTreeDepth {
    Node root;

    public BinaryTreeDepth() {
        this.root = null;
    }

    private int calculateDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = calculateDepth(node.left);
            int rightDepth = calculateDepth(node.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public int getDepth() {
        return calculateDepth(root);
    }
}

class Main {
    public static void main(String[] args) {
        BinaryTreeDepth tree = new BinaryTreeDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(4);

        int depth = tree.getDepth();
        System.out.println("Depth of the tree: " + depth);
    }
}
