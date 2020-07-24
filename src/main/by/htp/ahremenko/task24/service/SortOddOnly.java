package by.htp.ahremenko.task24.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 1) {
                sortedList.add(list.get(i));
            }
        }
        Collections.sort(sortedList);
        List<Integer> resultList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 1) {
                resultList.add(sortedList.get(j));
                j++;
            } else {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }
}
