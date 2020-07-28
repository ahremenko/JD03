package by.htp.ahremenko.task34.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
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
}