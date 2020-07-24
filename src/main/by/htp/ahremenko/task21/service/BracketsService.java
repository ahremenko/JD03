package by.htp.ahremenko.task21.service;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 2.1 Корректные скобочки
 * Дана строка, содержащая следующие символы: ‘)’, ‘(‘, ‘}’, ‘{’, ‘[’, ‘]’.
 * Задача: определить, является ли переданная строка корректной.
 * Она будет таковой, если:
 *  Открывающие скобочки должны быть закрыты закрывающими того же типа.
 *  Открывающие скобочки должны быть закрыты в нужном порядке.
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
        char[] ch = string.toCharArray();
        Stack<Character> stack = new Stack<>();

        try {
            for (char c : ch) {
                if (c == BRACKET_LEFT || c == SQUARE_BRACKET_LEFT || c == FIGURE_BRACKET_LEFT) {
                    stack.push(c);
                } else if (c == BRACKET_RIGHT || c == SQUARE_BRACKET_RIGHT || c == FIGURE_BRACKET_RIGHT) {
                    char last = stack.pop();
                    if (!((c == BRACKET_RIGHT && last == BRACKET_LEFT)
                            || (c == SQUARE_BRACKET_RIGHT && last == SQUARE_BRACKET_LEFT)
                            || (c == FIGURE_BRACKET_RIGHT && last == FIGURE_BRACKET_LEFT))) {
                        return false;
                    }
                }
            }
        } catch (EmptyStackException e) {
            return false;
        }
        return stack.empty();
    }
}
