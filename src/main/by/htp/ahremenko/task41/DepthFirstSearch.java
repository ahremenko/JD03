package by.htp.ahremenko.task41;

import by.htp.ahremenko.common.TreeNode;

import java.util.Deque;

import static java.util.Objects.nonNull;

public class DepthFirstSearch<T> implements SearchStrategy<T> {

    @Override
    public T next(Deque<TreeNode<T>> stack) {
        TreeNode<T> node = stack.removeFirst();
        T result = node.getValue();
        if (nonNull(node.getRight())) {
            stack.addFirst(node.getRight());
        }
        if (nonNull(node.getLeft())) {
            stack.addFirst(node.getLeft());
        }
        return result;
    }
}
