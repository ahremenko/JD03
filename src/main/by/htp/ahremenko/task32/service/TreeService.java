package by.htp.ahremenko.task32.service;

import by.htp.ahremenko.task32.domain.Tree;
import lombok.experimental.UtilityClass;

/**
 * 3.2 Глубина бинарного дерева (DFS)
 * Дана структура данных с первого задания.
 *
 * Задача: реализовать сервис, который принимает на вход бинарное дерево и возвращает его глубину
 */
@UtilityClass
public class TreeService {

    public static int getTreeHeight(Tree tree) {
        if (tree == null)
            return 0;
        int maxHeight = 0;
        return tree.getHeight();
    }
}
