package by.htp.ahremenko.task31.service;

import by.htp.ahremenko.task31.domain.Tree;
import lombok.experimental.UtilityClass;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 3.1 Количество узлов бинарного дерева (BST – binary search tree)
 * Дано бинарное дерево (узлы такого дерева могут иметь максимум два потомка: правый и левый).
 *
 * Задача: реализовать сервис, который принимает на вход бинарное дерево и подсчитывает количество узлов в нем.
 * Класс бинарного дерева необходимо написать самим, но он должно иметь как минимум 3 поля: значение узла (может быть любым типом),
 * ссылка на правого потомка и ссылка на левого потомка.
 *
 * Реализовать данную задачу двумя способами: циклом и рекурсией.
 */
@UtilityClass
public class TreeService {

    public static int getNodeAmountRecursive(Tree tree) {
        return tree.calcNodes();
    }

    public static int getNodeAmount(Tree tree) {
        Deque<Tree> stack = new LinkedList<>();
        int count = 0;
        stack.addFirst(tree);

        while (!stack.isEmpty()) {
            Tree node = stack.removeFirst();
            count++;
            if (node.getLeft() != null) {
                stack.addFirst(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.addFirst(node.getRight());
            }
        }
        return count;
    }
}
