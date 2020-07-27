package by.htp.ahremenko.task34.service;

import by.htp.ahremenko.task34.domain.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 3.4 Сложение символов (BFS)
 * Дано аналогичное дерево с первого задания (смотрите рисунок внизу).
 * <p>
 * Задача: реализовать сервис, который принимает на вход бинарное дерево, обходит его в ширину
 * (BFS – Breadth First Search) и возвращает строку, равную конкатенации символов всех узлов.
 * <p>
 * Примечание: Обход в ширину означает то, что сначала обрабатывается корень дерева, потом оба его потомка,
 * потом потомки потомков и т.д., т.е. обход идет слева направо по уровням.
 */

@UtilityClass
public class TreeService {

    public static String getBreadthFirstSearch(TreeNode tree) {
        if (tree == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {

            TreeNode node = queue.peek();
            if (node != null) {
                builder.append(node.getValue().toString());
                queue.remove();

                if (node.getLeft() != null)
                    queue.add(node.getLeft());

                if (node.getRight() != null)
                    queue.add(node.getRight());
            }
        }
        return builder.toString();
    }
}
