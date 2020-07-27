package by.htp.ahremenko.task31.domain;

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

    public int calcNodes() {
        int count = 1;
        if (left != null) {
            count += left.calcNodes();
        }
        if (right != null) {
            count += right.calcNodes();
        }
        return count;
    }
}
