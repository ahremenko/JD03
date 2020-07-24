package by.htp.ahremenko.task21.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BracketsServiceTest {

    @Test
    public void handleBracketsTrue() {
        BracketsService service = new BracketsService();
        boolean actual = service.handleBrackets("");
        assertTrue(actual);
    }

    @Test
    public void handleBracketsTrue2() {
        BracketsService service = new BracketsService();
        boolean actual = service.handleBrackets("()");
        assertTrue(actual);
    }

    @Test
    public void handleBracketsTrue3() {
        BracketsService service = new BracketsService();
        boolean actual = service.handleBrackets("[{}]()");
        assertTrue(actual);
    }

    @Test
    public void handleBracketsFalse() {
        BracketsService service = new BracketsService();
        boolean actual = service.handleBrackets("[{]()}");
        assertFalse(actual);
    }

    @Test
    public void handleBracketsFalse2() {
        BracketsService service = new BracketsService();
        boolean actual = service.handleBrackets("[{[()}]()");
        assertFalse(actual);
    }

    @Test
    public void handleBracketsFalse3() {
        BracketsService service = new BracketsService();
        boolean actual = service.handleBrackets("]{}");
        assertFalse(actual);
    }
}