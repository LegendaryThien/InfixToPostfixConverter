package org.example;

import java.util.HashMap;
import java.util.Stack;
/*
Name: Anh-Thien Nguyen
The InfixToPostfix class converts mathematical expressions
from infix notation to postfix notation, which is done
before evaluating the postfix result.
 */
public class InfixToPostfix {

    private static final HashMap<Character, Integer> precedence = new HashMap<>();

    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', 0);
        precedence.put('{', 0);
    }
    // Method to convert infix to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else if (c == '}') {
                while (!stack.isEmpty() && stack.peek() != '{') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}