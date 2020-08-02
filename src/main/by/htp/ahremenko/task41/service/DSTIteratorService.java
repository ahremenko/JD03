package by.htp.ahremenko.task41.service;

import by.htp.ahremenko.common.TreeNode;
import by.htp.ahremenko.task41.BSTIterator;
import by.htp.ahremenko.task41.Strategy;

public class DSTIteratorService {

    public String handle(Strategy<String> strategy, TreeNode<String> root) {
        StringBuilder builder = new StringBuilder();
        BSTIterator<String> iterator = new BSTIterator<>(strategy, root);
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        return builder.toString();
    }

    public String handle2(Strategy<String> strategy, TreeNode<String> root) {
        StringBuilder builder = new StringBuilder();
        BSTIterator<String> iterator = new BSTIterator<>(strategy, root);
        iterator.forEachRemaining( elem -> builder.append(elem));
        return builder.toString();
    }

}
