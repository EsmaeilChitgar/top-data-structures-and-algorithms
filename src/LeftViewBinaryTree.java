public class LeftViewBinaryTree {
    TreeNode root;
    int maxLevel = Integer.MIN_VALUE;

    // Helper function to print left view
    private void leftViewUtil(TreeNode node, int level) {
        // Base Case
        if (node == null) {
            return;
        }

        // Check if this is the first node at the current level
        if (level > maxLevel) {
            System.out.print(node.value + " ");
            maxLevel = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // Wrapper function to print left view
    public void leftView() {
        leftViewUtil(root, 0);
    }

    public static void main(String args[]) {
        LeftViewBinaryTree tree = new LeftViewBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println("Left view of the binary tree:");
        tree.leftView();
    }
}
