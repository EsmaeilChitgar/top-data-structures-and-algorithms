public class InorderSuccessor {
    TreeNode root;

    public static void main(String[] args) {
        InorderSuccessor tree = new InorderSuccessor();
        tree.root = new TreeNode(20);

        tree.root.left = new TreeNode(9);
        tree.root.left.parent = tree.root;

        tree.root.right = new TreeNode(25);
        tree.root.right.parent = tree.root;

        tree.root.left.left = new TreeNode(5);
        tree.root.left.left.parent = tree.root.left;

        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.parent = tree.root.left;

        tree.root.left.right.left = new TreeNode(11);
        tree.root.left.right.left.parent = tree.root.left.right;

        tree.root.left.right.right = new TreeNode(14);
        tree.root.left.right.right.parent = tree.root.left.right;

        new InvertBinaryTree().inOrderTraversal(tree.root);

        TreeNode node = tree.root;
        System.out.println("\nsuccessor of " + node.value + " is: " + tree.getSuccessor(node).value);

        node = tree.root.left;
        System.out.println("\nsuccessor of " + node.value + " is: " + tree.getSuccessor(node).value);

        node = tree.root.right;
        System.out.println("\nsuccessor of " + node.value + " is: " + tree.getSuccessor(node));

        node = tree.root.left.left;
        System.out.println("\nsuccessor of " + node.value + " is: " + tree.getSuccessor(node).value);

        node = tree.root.left.right;
        System.out.println("\nsuccessor of " + node.value + " is: " + tree.getSuccessor(node).value);
    }

    private TreeNode getSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return getMostLeft(node.right);
        }

        TreeNode parent = node.parent;
        TreeNode child = node;

        while (parent.right == child) {
            if (parent.parent == null) {
                return null;
            }

            child = parent;
            parent = parent.parent;
        }

        return parent;
    }

    private TreeNode getMostLeft(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        return getMostLeft(node.left);
    }
}
