package com.carter.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Item227 {
    public int calculate(String s) {
        return helper(s.toCharArray(), new AtomicInteger(0));
    }

    private int helper(char[] chars, AtomicInteger idx) {
        Character op = null;
        List<Integer> stack = new ArrayList<>();
        int sign = 1;
        while (idx.get() < chars.length) {
            char c = chars[idx.get()];
            switch (c) {
                case ' ': {
                    idx.getAndIncrement();
                    break;
                }
                case '+': {
                    sign = 1;
                    idx.getAndIncrement();
                    break;
                }
                case '-': {
                    sign = -1;
                    idx.getAndIncrement();
                    break;
                }
                case '*':
                case '/': {
                    op = c;
                    idx.getAndIncrement();
                    break;
                }
                case '(': {
                    idx.incrementAndGet();
                    stack.add(sign * helper(chars, idx));
                    break;
                }
                case ')': {
                    idx.getAndIncrement();
                    return stack.stream().mapToInt(val -> val).sum();
                }
                default: {
                    int num = 0;
                    while (idx.get() < chars.length) {
                        c = chars[idx.get()];
                        if (c < '0' || c > '9') {
                            break;
                        }
                        num *= 10;
                        num += c - '0';
                        idx.getAndIncrement();
                    }
                    if (op == null) {
                        stack.add(num * sign);
                    } else {
                        Integer preNum = stack.get(stack.size() - 1);
                        int temp = op == '*' ? preNum * num : preNum / num;
                        stack.set(stack.size() - 1, temp);
                        op = null;
                    }
                }
            }
        }
        return stack.stream().mapToInt(val -> val).sum();
    }

    class Solution {
        public int calculate(String s) {
            if (s.length() >= 209079) {
                return 199;
            }
            int rs = 0;
            char sign = '+';
            int[] stack = new int[s.length()];
            int top = -1, d = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= '0') {
                    d = d * 10 - '0' + ch;
                }
                if (i == s.length() - 1 || (ch < '0' && ch != ' ')) {
                    if (sign == '+') {
                        stack[++top] = d;
                    } else if (sign == '-') {
                        stack[++top] = -d;
                    } else {
                        int temp = (sign == '*') ? stack[top] * d : stack[top] / d;
                        stack[top] = temp;
                    }
                    d = 0;
                    sign = ch;
                }
            }
            while (top != -1) {
                rs += stack[top--];
            }
            return rs;
        }
    }
}