package by.htp.ahremenko.task23.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DominantServiceTest {

    @Test
    public void handle() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 9, 9, 10, 9));
        int actual = DominantService.handle(list);
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void handle2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 1, 1, 2, 2, 3));
        int actual = DominantService.handle(list);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void handleNoDominant() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 1, 1, 4, 4));
        Integer actual = DominantService.handle(list);
        assertNull(actual);
    }

}