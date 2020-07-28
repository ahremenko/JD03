package by.htp.ahremenko.task31.domain;

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
