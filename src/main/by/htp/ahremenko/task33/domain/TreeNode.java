package by.htp.ahremenko.task33.domain;

public class TreeNode {

    private Object value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Object value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void preOrder(StringBuilder builder) {
        builder.append(value.toString());
        if (left != null) {
            left.preOrder(builder);
        }
        if (right != null) {
            right.preOrder(builder);
        }
    }

    public void inOrder(StringBuilder builder) {
        if (left != null) {
            left.inOrder(builder);
        }
        builder.append(value.toString());
        if (right != null) {
            right.inOrder(builder);
        }
    }

    public void postOrder(StringBuilder builder) {
        if (left != null) {
            left.postOrder(builder);
        }
        if (right != null) {
            right.postOrder(builder);
        }
        builder.append(value.toString());
    }

}
