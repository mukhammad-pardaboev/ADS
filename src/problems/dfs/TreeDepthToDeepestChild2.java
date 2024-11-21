package problems.dfs;

public class TreeDepthToDeepestChild2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        TreeNode grandchild1 = new TreeNode(5);
        TreeNode grandchild2 = new TreeNode(6);
        TreeNode grandchild3 = new TreeNode(7);
        TreeNode grandgrandchild1 = new TreeNode(8);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        child1.children.add(grandchild1);
        child2.children.add(grandchild2);
        child2.children.add(grandchild3);
        grandchild1.children.add(grandgrandchild1);

        int[] depths = new int[countNodes(root)];
        calculateDepths(root, depths, 0);

        for (int i = 0; i < depths.length; i++) {
            System.out.println("Depth of node " + (i + 1) + ": " + depths[i]);
        }
    }

    private static int countNodes(TreeNode node) {
        if (node == null)
            return 0;
        int count = 1;
        for (TreeNode child : node.children) {
            count += countNodes(child);
        }
        return count;
    }

    private static void calculateDepths(TreeNode node, int[] depths, int depth) {
        depths[node.val - 1] = depth;
        for (TreeNode child : node.children) {
            calculateDepths(child, depths, depth + 1);
        }
    }
}
