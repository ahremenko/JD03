package by.htp.ahremenko.task33.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TreeNode<T> {

    @Getter
    @NonNull
    private T value;

    @Getter
    private TreeNode left;

    @Getter
    private TreeNode right;

    public TreeNode(T value) {
        this.value = value;
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
