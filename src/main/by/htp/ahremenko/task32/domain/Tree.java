package by.htp.ahremenko.task32.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Tree<T> {

    @Getter
    @NonNull
    private T value;

    @Getter
    private Tree left;

    @Getter
    private Tree right;

    public Tree(T value) {
        this.value = value;
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