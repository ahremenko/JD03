package by.htp.ahremenko.task32.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Tree<T> {

    @NonNull
    private T value;

    private Tree<T> left;
    private Tree<T> right;

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