package problems.dfs;

public class TreeDepthToDeepestChild1 {
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

        int[] depths = new int[root.children.size()];
        calculateDepths(root, depths);

        for (int i = 0; i < depths.length; i++) {
            System.out.println("Depth of node " + (i + 1) + ": " + depths[i]);
        }
    }

    private static int calculateDepths(TreeNode node, int[] depths) {
        if (node.children.isEmpty()) {
            return 0;
        }

        int maxDepth = 0;
        for (int i = 0; i < node.children.size(); i++) {
            TreeNode child = node.children.get(i);
            int childDepth = calculateDepths(child, depths) + 1;
            depths[i] = childDepth;
            maxDepth = Math.max(maxDepth, childDepth);
        }

        return maxDepth;
    }
}
