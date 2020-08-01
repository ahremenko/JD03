package by.htp.ahremenko.task41.service;

import by.htp.ahremenko.common.TreeNode;
import by.htp.ahremenko.task41.BSTIterator;
import by.htp.ahremenko.task41.BreadthFirstSearch;
import by.htp.ahremenko.task41.DepthFirstSearch;

public class DSTIteratorService {

    public String handleDFSStrategy(TreeNode<String> root) {
        StringBuilder builder = new StringBuilder();
        BSTIterator<String> iterator = new BSTIterator<>(root);
        DepthFirstSearch<String> searchStrategy = new DepthFirstSearch();
        iterator.setSearchStrategy(searchStrategy);
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        return builder.toString();
    }

    public String handleBFSStrategy(TreeNode<String> root) {
        StringBuilder builder = new StringBuilder();
        BSTIterator<String> iterator = new BSTIterator<>(root);
        BreadthFirstSearch<String> searchStrategy = new BreadthFirstSearch<>();
        iterator.setSearchStrategy(searchStrategy);
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        return builder.toString();
    }
}
