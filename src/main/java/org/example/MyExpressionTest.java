package org.example;

import java.util.Scanner;
/*
Name: Anh-Thien Nguyen
Student ID: 202660307
Date: 2/23/24
Description: The purpose of this java program is to evaluate
mathematical expressions given by user input. It then validates
the syntax of the expression, converts it from infix to postfix
notation, and then evaluates the result. The program will continue
to ask the user for inpt until the "exit" command is inputted.
Incorrect expressions are flagged with an error message and indicated
point of failure.

This java file is the MyExpressionTest file which is the file that
contains the main method that is connected by the other three
classes. It asks the user for input, uses the ExpressionEvaluation
class to validate the expression, the InfixtoPostfix class to convert it,
then the PostfixEvaluation class to evaluate the result.
 */
public class MyExpressionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CS 211. Winter Quarter 2024");
        while (true) {
            System.out.print("Enter a math expression (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Bye.");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Invalid expression: The expression is empty.");
                continue;
            }

            boolean isValid = ExpressionEvaluation.expressionEvaluation(input);
            if (!isValid) {
                System.out.println(input);
                int errorIndex = ExpressionEvaluation.getErrorIndex();
                for (int i = 0; i < errorIndex; i++) {
                    System.out.print(" ");
                }
                System.out.println("^ Incomplete Expression");
                continue;
            }

            String postfix = InfixToPostfix.infixToPostfix(input);
            int result = PostfixEvaluation.evaluatePostfix(postfix.replaceAll("[\\[\\](){}]", ""));

            System.out.println("infix: " + input);
            System.out.println("postfix: " + postfix);
            System.out.println("result: " + result);
        }

        scanner.close();
    }
}
