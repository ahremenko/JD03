package by.htp.ahremenko.task32.domain;

public class Tree {
    private Object value;
    private Tree left;
    private Tree right;

    public Tree(Object value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (left != null) {
            leftHeight = left.getHeight();
        }
        if (right != null) {
            rightHeight = right.getHeight();
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

}