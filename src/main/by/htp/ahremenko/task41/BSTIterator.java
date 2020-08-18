package by.htp.ahremenko.task41;

import by.htp.ahremenko.common.TreeNode;
import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;



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
public class BSTIterator<T> implements Iterator<T> {

    private Deque<TreeNode<T>> stack = new ArrayDeque<>();
    private Strategy<T> strategy;

    public BSTIterator(@NonNull Strategy<T> strategy, @NonNull TreeNode<T> root) {
        this.strategy = strategy;
        stack.addFirst(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        return strategy.next(stack);
    }
}
