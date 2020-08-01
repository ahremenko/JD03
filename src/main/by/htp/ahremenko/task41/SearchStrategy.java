package by.htp.ahremenko.task41;

import by.htp.ahremenko.common.TreeNode;

import java.util.Deque;

interface SearchStrategy<T> {

    T next(Deque<TreeNode<T>> stack);
}
