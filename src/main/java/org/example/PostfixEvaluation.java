package org.example;

import java.util.Stack;
/*
Name: Anh-Thien Nguyen
The PostfixEvaluation class is used to evaluate the result
after the mathematical expression is converted from infix to
postfix. It uses stack to handle operands and operators and
performs calculations according to the rules of postfix evaluation.
 */
public class PostfixEvaluation {

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Convert char to int and push
            } else {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();

                if (c == '+') {
                    stack.push(leftOperand + rightOperand);
                } else if (c == '-') {
                    stack.push(leftOperand - rightOperand);
                } else if (c == '*') {
                    stack.push(leftOperand * rightOperand);
                } else if (c == '/') {
                    stack.push(leftOperand / rightOperand);
                }
            }
        }

        return stack.pop();
    }
}