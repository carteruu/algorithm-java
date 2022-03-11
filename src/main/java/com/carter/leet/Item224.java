package com.carter.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Item224 {
    public int calculate(String s) {
        return helper(s.toCharArray(), new AtomicInteger(0));
    }

    private int helper(char[] chars, AtomicInteger idx) {
        int ans = 0;
        int sign = 1;
        while (idx.get() < chars.length) {
            switch (chars[idx.get()]) {
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
                case '(': {
                    idx.incrementAndGet();
                    ans += sign * helper(chars, idx);
                    break;
                }
                case ')': {
                    idx.getAndIncrement();
                    return ans;
                }
                default: {
                    int num = 0;
                    while (idx.get() < chars.length) {
                        char c = chars[idx.get()];
                        if (c < '0' || c > '9') {
                            break;
                        }
                        num *= 10;
                        num += c - '0';
                        idx.getAndIncrement();
                    }
                    ans += num * sign;
                }
            }
        }
        return ans;
    }

    public int calculate1(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int idx = 0;
        int sign = 1;
        List<Integer> opsStack = new ArrayList<>();
        opsStack.add(1);
        while (idx < chars.length) {
            switch (chars[idx]) {
                case ' ': {
                    idx++;
                    break;
                }
                case '+': {
                    sign = opsStack.get(opsStack.size() - 1);
                    idx++;
                    break;
                }
                case '-': {
                    sign = -opsStack.get(opsStack.size() - 1);
                    idx++;
                    break;
                }
                case '(': {
                    opsStack.add(sign);
                    idx++;
                    break;
                }
                case ')': {
                    opsStack.remove(opsStack.size() - 1);
                    idx++;
                    break;
                }
                default: {
                    int num = 0;
                    while (idx < chars.length) {
                        char c = chars[idx];
                        if (c >= '0' && c <= '9') {
                            num *= 10;
                            num += c - '0';
                            idx++;
                            continue;
                        }
                        break;
                    }
                    ans += num * sign;
                }
            }
        }
        return ans;
    }
}
