public class SumOfDepthsOfBinaryTreeNodes {
    TreeNode root;

    private int sumDepths(TreeNode node, int depth) {
        // Base Case
        if (node == null) {
            return 0;
        }

        return depth + sumDepths(node.left, depth + 1) + sumDepths(node.right, depth + 1);
    }

    public static void main(String[] args) {
        SumOfDepthsOfBinaryTreeNodes tree = new SumOfDepthsOfBinaryTreeNodes();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.left.left.left = new TreeNode(8);
        tree.root.left.left.right = new TreeNode(9);

        System.out.println("sum od depths: " + tree.sumDepths(tree.root, 0));
    }
}
