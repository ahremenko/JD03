package by.htp.ahremenko.task41;

import by.htp.ahremenko.common.TreeNode;

import java.util.Deque;

public interface Strategy<T> {

    T next(Deque<TreeNode<T>> stack);
}
