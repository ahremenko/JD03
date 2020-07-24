package by.htp.ahremenko.task22.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2.2 Анаграммы
 * Анаграммы – это слова, которые состоят из одних и тех же символов, но в разном порядке.
 * Дан массив строк, найти в нем анаграммы и вернуть список групп этих анаграмм.
 * Каждый список отсортирован в алфавитном порядке. Оценить сложность написанного алгоритма.
 * <p>
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
public final class AnagramService {

    private AnagramService() {
    }

    public static List<List<String>> handle(List<String> list) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Integer found = null;
            for (int j = 0; j < result.size(); j++) {
                if (isAnagram(list.get(i), result.get(j).get(0))) {
                    found = j;
                    break;
                }
            }
            if (found != null) {
                result.get(found).add(list.get(i));
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(list.get(i));
                result.add(anagrams);
            }
        }
        result.forEach(a -> Collections.sort(a));
        return result;
    }

    public static boolean isAnagram(String firstWord, String secondWord) {
        char[] word1 = firstWord.toLowerCase().replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.toLowerCase().replaceAll("[\\s]", "").toCharArray();
        Map<Character, Integer> lettersMap = new HashMap<>();

        for (char c : word1) {
            int count = 1;
            if (lettersMap.containsKey(c)) {
                count = lettersMap.get(c) + 1;
            }
            lettersMap.put(c, count);
        }

        for (char c : word2) {
            int count = -1;
            if (lettersMap.containsKey(c)) {
                count = lettersMap.get(c) - 1;
            }
            lettersMap.put(c, count);
        }

        for (char c : lettersMap.keySet()) {
            if (lettersMap.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
