package com.pg.programmercarl.stackqueue;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int evalRPN = reversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println("evalRPN = " + evalRPN);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer later = stack.pop();
                    Integer prev = stack.pop();
                    stack.push(prev / later);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;

            }
        }
        return stack.pop();
    }
}
