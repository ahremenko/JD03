package by.htp.ahremenko.task41;

import by.htp.ahremenko.common.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static java.util.Objects.nonNull;

/**
 * 4.1 Tree Iterator
 * Для обхода любой структуры данных используется знаменитый паттерн проектирования
 * под названием «Итератор». В данном случае дано бинарное дерево с прошлых заданий,
 * т.е. такое дерево, каждый узел которого имеет максимум двух потомков (левый, правый)
 * и какое-то значение.
 * <p>
 * Задача: реализовать итератор по бинарному дереву (необходимо реализовать нужный интерфейс
 * из JDK), и переопределить методы:
 * <p>
 * next() – будет возвращать следующий узел дерева
 * <p>
 * hasNext() – возвращает true, если следующий элемент дерева существует, иначе false.
 * <p>
 * Объект вашего итератора должен инициализироваться с помощью переданного в него объекта
 * дерева (корень). Классы итератора и дерева должны быть обобщенными.
 * Также предусмотреть вариант обхода дерева разными способами (DFS - pre-order и BFS)
 * с помощью паттерна «Стратегия». Сам объект стратегии должен быть в единственном числе,
 * другими словами, реализовать паттерн «Одиночка».
 *
 * @param <T> - type of TreeNode
 */
public class BSTIterator<T> implements Iterator {

    private Deque<TreeNode<T>> stack;

    @Setter
    private SearchStrategy<T> searchStrategy;

    public BSTIterator(TreeNode<T> root) {
        stack = new ArrayDeque<>();
        if (nonNull(root)) {
            stack.addFirst(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public T next() {
        return searchStrategy.next(stack);
    }
}
