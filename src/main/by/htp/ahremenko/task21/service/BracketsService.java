package by.htp.ahremenko.task21.service;

import java.util.*;

/**
 * 2.1 Корректные скобочки
 * Дана строка, содержащая следующие символы: ‘)’, ‘(‘, ‘}’, ‘{’, ‘[’, ‘]’.
 * Задача: определить, является ли переданная строка корректной.
 * Она будет таковой, если:
 * Открывающие скобочки должны быть закрыты закрывающими того же типа.
 * Открывающие скобочки должны быть закрыты в нужном порядке.
 * Пустая строка тоже считается правильной.
 */
public class BracketsService {

    private static final char BRACKET_LEFT = '(';
    private static final char BRACKET_RIGHT = ')';
    private static final char SQUARE_BRACKET_LEFT = '[';
    private static final char SQUARE_BRACKET_RIGHT = ']';
    private static final char FIGURE_BRACKET_LEFT = '{';
    private static final char FIGURE_BRACKET_RIGHT = '}';

    public boolean handleBrackets(String string) {
        if (string.length() % 2 == 1) {
            return false;
        }
        char[] charArray = string.toCharArray();
        Deque<Character> charStack = new ArrayDeque<>();
        try {
            for (char ch : charArray) {
                if (ch == BRACKET_LEFT || ch == SQUARE_BRACKET_LEFT || ch == FIGURE_BRACKET_LEFT) {
                    charStack.addFirst(ch);
                } else if (ch == BRACKET_RIGHT || ch == SQUARE_BRACKET_RIGHT || ch == FIGURE_BRACKET_RIGHT) {
                    char last = charStack.removeFirst();
                    if (!((ch == BRACKET_RIGHT && last == BRACKET_LEFT)
                            || (ch == SQUARE_BRACKET_RIGHT && last == SQUARE_BRACKET_LEFT)
                            || (ch == FIGURE_BRACKET_RIGHT && last == FIGURE_BRACKET_LEFT))) {
                        return false;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return charStack.isEmpty();
    }
}
