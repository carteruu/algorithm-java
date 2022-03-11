package com.carter.leet;

import java.util.*;

public class Item1190 {
    public static void main(String[] args) {
        System.out.println(new Item1190().reverseParentheses("123456"));
    }

    public String reverseParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] brackets = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                Integer left = stack.pop();
                brackets[i] = left;
                brackets[left] = i;
            }
        }

        int i = 0;
        int step = 1;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = brackets[i];
                step = -step;
            } else {
                sb.append(s.charAt(i));
            }
            i += step;
        }
        return sb.toString();
    }

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
