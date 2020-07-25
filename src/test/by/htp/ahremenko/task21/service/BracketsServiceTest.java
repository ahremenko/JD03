package by.htp.ahremenko.task21.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BracketsServiceTest {

    private BracketsService service = new BracketsService();

    @Test
    public void handleBracketsTrue() {
        boolean actual = service.handleBrackets("");
        assertTrue(actual);
    }

    @Test
    public void handleBracketsTrue2() {
        boolean actual = service.handleBrackets(")(");
        assertFalse(actual);
    }

    @Test
    public void handleBracketsTrue3() {
        boolean actual = service.handleBrackets("[{}]()");
        assertTrue(actual);
    }

    @Test
    public void handleBracketsFalse() {
        boolean actual = service.handleBrackets("[{]()}");
        assertFalse(actual);
    }

    @Test
    public void handleBracketsFalse2() {
        boolean actual = service.handleBrackets("[{[()}]()");
        assertFalse(actual);
    }

    @Test
    public void handleBracketsFalse3() {
        boolean actual = service.handleBrackets("]{}");
        assertFalse(actual);
    }
}