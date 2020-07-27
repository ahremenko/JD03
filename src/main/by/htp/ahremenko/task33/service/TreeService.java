package by.htp.ahremenko.task33.service;

import by.htp.ahremenko.task33.domain.TreeNode;
import lombok.experimental.UtilityClass;

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

    public static String getTraversalInOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        treeNode.inOrder(builder);
        return builder.toString();
    }

    public static String getTraversalPreOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        treeNode.preOrder(builder);
        return builder.toString();
    }

    public static String getTraversalPostOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        treeNode.postOrder(builder);
        return builder.toString();
    }
}
