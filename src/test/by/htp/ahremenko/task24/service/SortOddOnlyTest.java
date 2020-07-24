package by.htp.ahremenko.task24.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortOddOnlyTest {

    @Test
    public void handle() {
        List<Integer> list = Arrays.asList(5, 3, 2, 8, 1, 4);
        List<Integer> actualList = SortOddOnly.handle(list);
        List<Integer> expectedList = Arrays.asList(1, 3, 2, 8, 5, 4);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void handle2() {
        List<Integer> list = Arrays.asList(7, 2, 5, 9, 1, 4, 12, 45, 77);
        List<Integer> actualList = SortOddOnly.handle(list);
        List<Integer> expectedList = Arrays.asList(1, 2, 5, 7, 9, 4, 12, 45, 77);
        assertEquals(expectedList, actualList);
    }
}