package by.htp.ahremenko.task22.service;

import com.sun.deploy.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2.2 Анаграммы
 * Анаграммы – это слова, которые состоят из одних и тех же символов, но в разном порядке.
 * Дан массив строк, найти в нем анаграммы и вернуть список групп этих анаграмм.
 * Каждый список отсортирован в алфавитном порядке. Оценить сложность написанного алгоритма.
 * Пример:
 * ["eat", "tea", "tan", "ate", "nat", "bat"]
 * На выходе должны получить:
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * Примечание: каждая группа анаграмм тоже должна быть в нужном порядке,
 * т.е. группа ["ate", "eat","tea"] идет первой, потому что слово “eat” было найдено первым
 * в исходном массиве, ["nat","tan"] второй, потому что “tan” было найдено вторым
 * (вообще третьим, но т.к. “tea” вошло в первую группу анаграмм, то считается вторым) и т.д.
 */
@UtilityClass
public class AnagramService {

    public static List<List<String>> handle(List<String> list) {
        Map<String,List<String>> result = new LinkedHashMap<>();

        for (String word : list) {
            char[] letters = word.toLowerCase().replaceAll("[\\s]", "").toCharArray();
            Arrays.sort(letters);
            String mapKey = new String(letters);
            List<String> mapValue = result.computeIfAbsent(mapKey, k -> new ArrayList<>());
            mapValue.add(word);
        }
        return result.values().stream()
                .peek(lst -> lst.sort(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}
