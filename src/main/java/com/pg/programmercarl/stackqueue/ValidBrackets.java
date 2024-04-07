package com.pg.programmercarl.stackqueue;

import java.util.Stack;

public class ValidBrackets {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            switch (c) {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public String removeDuplicates(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        char[] res = new char[stack.size()];
        int idx = res.length - 1;
        while (!stack.isEmpty()) {
            res[idx--] = stack.pop();
        }
        return new String(res);
    }
}
