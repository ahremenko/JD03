package by.htp.ahremenko.task33.domain;

public class TreeNode<T> {

    private T value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
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
