package by.htp.ahremenko.task33.service;

import by.htp.ahremenko.task33.domain.TreeNode;
import lombok.experimental.UtilityClass;

import static java.util.Objects.nonNull;

/**
 * 3.3 Сложение символов (DFS)
 * Дана структура данных с первого задания (смотрите рисунок внизу). Каждый узел дерева содержит какую-то букву, например, ‘s’.
 *
 * Задача: реализовать сервис, который принимает на вход бинарное дерево, обходит его в глубину и возвращает строку,
 * равную конкатенации символов всех узлов. Учесть тот факт, что узлы дерева можно обходить в глубину
 * тремя разными способами (pre-order, in-order, post-order), что влияет на итоговую строку,
 * следовательно, необходимо реализовать все три варианта обхода.
 */
@UtilityClass
public class TreeService {

    public static StringBuilder getTraversalInOrder(TreeNode treeNode) {
        StringBuilder result = new StringBuilder();
        if (nonNull(treeNode)) {
            result.append(getTraversalInOrder(treeNode.getLeft()));
            result.append(treeNode.getValue());
            result.append(getTraversalInOrder(treeNode.getRight()));
        }
        return result;
    }

    public static StringBuilder getTraversalPreOrder(TreeNode treeNode) {
        StringBuilder result = new StringBuilder();
        if (nonNull(treeNode)) {
            result.append(treeNode.getValue());
            result.append(getTraversalPreOrder(treeNode.getLeft()));
            result.append(getTraversalPreOrder(treeNode.getRight()));
        }
        return result;
    }

    public static StringBuilder getTraversalPostOrder(TreeNode treeNode) {
        StringBuilder result = new StringBuilder();
        if (nonNull(treeNode)) {
            result.append(getTraversalPostOrder(treeNode.getLeft()));
            result.append(getTraversalPostOrder(treeNode.getRight()));
            result.append(treeNode.getValue());
        }
        return result;
    }
}
