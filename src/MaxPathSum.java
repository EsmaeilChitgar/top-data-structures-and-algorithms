public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    private Integer maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private Integer findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(findMax(node.left), 0);
        int rightMax = Math.max(findMax(node.right), 0);

        int maxOfCurrentNode = leftMax + node.value + rightMax;
        maxSum = Math.max(maxSum, maxOfCurrentNode);

        return node.value + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println("Maximum Path Sum: " + maxPathSum.maxPathSum(root));
    }
}
