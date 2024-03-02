package org.example;

import java.util.Stack;
/*
Name: Anh-Thien Nguyen
The ExpressionEvaluation class is used to evaluate
whether the syntax of a mathematical expression the user
inputs is valid or invalid. The mathematical expression
is evaluated before converted to postfix.
 */
public class ExpressionEvaluation {
    private static int errorIndex = -1; // Default to -1 when no error

    public static int getErrorIndex() {
        return errorIndex;
    }

    public static boolean expressionEvaluation(String statement) {
        Stack<Character> stack = new Stack<>();
        boolean valid = true;
        errorIndex = -1; // Reset error index at the start

        for (int j = 0; j < statement.length(); j++) {
            char c = statement.charAt(j);

            if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}') {
                if (stack.isEmpty() || (c == ')' && stack.peek() != '(') || (c == '}' && stack.peek() != '{')) {
                    valid = false;
                    errorIndex = j; // Set error index
                    break;
                }
                stack.pop();
            }
        }

        if (valid && !stack.isEmpty()) {
            valid = false;
            errorIndex = statement.length(); // Error at the end of the expression
        }

        return valid;
    }
}
