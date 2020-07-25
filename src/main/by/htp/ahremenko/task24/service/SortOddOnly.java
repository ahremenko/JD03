package by.htp.ahremenko.task24.service;

import java.util.*;

/**
 * 2.4 Сортировка массива
 * Задача - написать функцию, которая на вход принимает массив целочисленных значений
 * и сортирует его так, что только нечетные значения отсортированы по возрастанию,
 * четные же находятся на тех же местах, что и были.
 * <p>
 * Пример:
 * <p>
 * [5, 3, 2, 8, 1, 4] -> [1, 3, 2, 8, 5, 4]
 */
public final class SortOddOnly {

    private SortOddOnly() {
    }

    public static List<Integer> handle(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>();
        for (int element : list) {
            if (element % 2 == 1) {
                sortedList.add(element);
            }
        }
        Collections.sort(sortedList);
        Queue<Integer> oddElements = new LinkedList<>();
        sortedList.forEach(element -> oddElements.add(element));
        List<Integer> resultList = new ArrayList<>();
        for (int element : list) {
            if (element % 2 == 1) {
                resultList.add(oddElements.poll());
            } else {
                resultList.add(element);
            }
        }
        return resultList;
    }
}
