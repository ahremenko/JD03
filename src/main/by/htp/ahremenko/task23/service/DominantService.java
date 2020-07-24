package by.htp.ahremenko.task23.service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

/**
 * 2.3 Доминирующий элемент
 * Доминирующий элемент – это элемент, который появляется в множестве более чем N / 2
 * (где N – количество элементов в множестве).
 * Задача – написать сервис, который принимает список элементов целочисленных значений,
 * а возвращает доминирующий элемент.
 * Например:
 * [10, 9, 9, 9, 10] – доминирующий элемент 9
 * [3, 2, 3] – доминирующий элемент 3
 * [2, 2, 1, 1, 1, 2, 2] – доминирующий элемент 2
 * Примечание: список элементов обязан иметь доминирующее число.
 * Задачу необходимо решить с использованием необходимых структур данных.
 * Второе решение желательно тоже реализовать, которое позволяет оптимально найти
 * доминирующее число за O(n).
 */
public final class DominantService {

    private DominantService() {
    }

    public static Integer handle(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : list) {
            map.put(elem, map.getOrDefault(elem,0) + 1);
        }
        Map.Entry<Integer, Integer> maxPair = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (maxPair == null || entry.getValue().compareTo(maxPair.getValue()) > 0)
            {
                maxPair = entry;
            }
        }
        return maxPair.getKey();
    }
}
