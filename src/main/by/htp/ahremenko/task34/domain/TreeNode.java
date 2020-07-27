package by.htp.ahremenko.task34.domain;

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
}