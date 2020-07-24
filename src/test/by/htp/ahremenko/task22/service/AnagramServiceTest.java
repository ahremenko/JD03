package by.htp.ahremenko.task22.service;

import by.htp.ahremenko.task22.service.AnagramService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class AnagramServiceTest {

    @Test
    public void handle() {

        List<String> list = new ArrayList<>(Arrays.asList("eat", "tEa", "tan", "ate", "nat", "bat"));
        List<List<String>> actualList = AnagramService.handle(list);

        List<List<String>> expectedList = new ArrayList<>();

        List<String> list1 = new ArrayList<>(Arrays.asList("ate", "eat", "tEa"));
        expectedList.add(list1);

        List<String> list2 = new ArrayList<>(Arrays.asList("nat", "tan"));
        expectedList.add(list2);

        List<String> list3 = new ArrayList<>(Arrays.asList("bat"));
        expectedList.add(list3);

        for (int i = 0; i < expectedList.size(); i++) {
            String[] actual = new String[actualList.get(i).size()];
            for (int j = 0; j < actualList.get(i).size(); j++) {
                actual[j] = actualList.get(i).get(j);
            }
            String[] expected = new String[expectedList.get(i).size()];
            for (int j = 0; j < expectedList.get(i).size(); j++) {
                expected[j] = expectedList.get(i).get(j);
            }
            assertArrayEquals(expected, actual);
        }
    }
}
