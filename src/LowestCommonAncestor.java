public class LowestCommonAncestor {
    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.value == p || root.value == q) {
            return root;
        }

        TreeNode lcaLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaRight = lowestCommonAncestor(root.right, p, q);

        if (lcaLeft != null && lcaRight != null) {
            return root;
        }

        return lcaLeft != null ? lcaLeft : lcaRight;
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing a sample binary tree
        //TreeNode root = new TreeNode(3);
        //root.left = new TreeNode(5);
        //root.right = new TreeNode(1);
        //root.left.left = new TreeNode(6);
        //root.left.right = new TreeNode(2);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(8);
        //root.left.right.left = new TreeNode(7);
        //root.left.right.right = new TreeNode(4);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();

        //// Finding the LCA of nodes with values 5 and 1
        //TreeNode lca = lcaFinder.lowestCommonAncestor(root, root.left, root.right);
        //System.out.println("Lowest Common Ancestor: " + lca.value);  // Output: 3
        System.out.println("Lowest Common Ancestor: " + lcaFinder.lowestCommonAncestor(root, 4, 5).value);  // Output: 3
        System.out.println("Lowest Common Ancestor: " + lcaFinder.lowestCommonAncestor(root, 4, 6).value);  // Output: 3
        System.out.println("Lowest Common Ancestor: " + lcaFinder.lowestCommonAncestor(root, 3, 4).value);  // Output: 3
        System.out.println("Lowest Common Ancestor: " + lcaFinder.lowestCommonAncestor(root, 2, 4).value);  // Output: 3
    }
}