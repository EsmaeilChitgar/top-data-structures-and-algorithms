import java.util.Objects;

class TreeNode{
    public int value;
    TreeNode left, right, parent;

    TreeNode(int value) {
        this.value = value;
        this.left = this.right = this.parent = null;
    }

    @Override
    public boolean equals(Object obj) {
        TreeNode node = (TreeNode) obj;
        return node.value==this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}