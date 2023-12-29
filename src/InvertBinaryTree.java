public class InvertBinaryTree {
    private TreeNode invertTree(TreeNode node) {
        if (node != null) {
            TreeNode temp = new TreeNode(node.value);
            temp.right = node.right;
            temp.left = node.left;
            node.left = temp.right;
            node.right = temp.left;

            invertTree(node.left);
            invertTree(node.right);
        }

        return node;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node==null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        // Example binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InvertBinaryTree inverter = new InvertBinaryTree();
        System.out.println("Original tree (in-order traversal):");
        inverter.inOrderTraversal(root);

        // Invert the binary tree
        TreeNode invertedRoot = inverter.invertTree(root);

        System.out.println("\n\nInverted tree (in-order traversal):");
        inverter.inOrderTraversal(invertedRoot);
    }
}
