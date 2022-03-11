package com.carter.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Item678 {

    class Solution {
        public boolean checkValidString(String s) {
            int low = 0;
            int high = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    low++;
                    high++;
                } else if (s.charAt(i) == ')') {
                    low = low == 0 ? 0 : --low;
                    high--;
                } else if (s.charAt(i) == '*') {
                    low = low == 0 ? 0 : --low;
                    high++;
                }

                if (high < 0) {
                    return false;
                }

            }
            return low == 0;
        }
    }

    class Solution1 {

        public boolean checkValidString(String s) {
            int n = s.length();
            Stack<Integer> leftStack = new Stack<>();
            Stack<Integer> starStack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    leftStack.push(i);//存的是下标
                } else if (s.charAt(i) == '*') {
                    starStack.push(i);
                } else {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    } else {
                        if (!starStack.isEmpty()) {
                            starStack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (starStack.size() < leftStack.size()) {
                return false;
            } else {
                while (!starStack.isEmpty() && !leftStack.isEmpty()) {
                    if (starStack.peek() < leftStack.peek()) {
                        return false;
                    }
                    starStack.pop();
                    leftStack.pop();
                }
                return true;
            }
        }
    }

    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                max--;
                if (max < 0) {
                    return false;
                }
            } else {
                if (min > 0) {
                    min--;
                }
                max++;
            }
        }
        return min == 0;
    }

    public boolean checkValidString3(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        boolean[] temp;
        dp[0] = true;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            temp = new boolean[n + 1];
            char c = chars[i - 1];
            if (c == '(') {
                System.arraycopy(dp, 0, temp, 1, n);
            } else if (c == ')') {
                System.arraycopy(dp, 1, temp, 0, n);
            } else {
                for (int j = 0; j <= n; j++) {
                    temp[j] = dp[j] || (j > 0 && dp[j - 1]) || (j < n && dp[j + 1]);
                }
            }
            dp = temp;
        }
        return dp[0];
    }

    public boolean checkValidString2(String s) {
        char[] chars = s.toCharArray();
        return dfs1(chars, 0, 0);
    }

    private boolean dfs1(char[] chars, int idx, int leftCount) {
        while (idx < chars.length) {
            char c = chars[idx];
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount <= 0) {
                    return false;
                }
                leftCount--;
            } else {
                idx++;
                return ((chars.length - idx) >= leftCount && dfs1(chars, idx, leftCount)) ||
                        ((chars.length - idx) >= leftCount + 1 && dfs1(chars, idx, leftCount + 1)) ||
                        (leftCount >= 1 && dfs1(chars, idx, leftCount - 1));
            }
            idx++;
        }
        return leftCount == 0;
    }

    public boolean checkValidString1(String s) {
        List<Character> stack = new ArrayList<>(s.length());
        char[] chars = s.toCharArray();
        return dfs(stack, chars, 0);
    }

    private boolean dfs(List<Character> stack, char[] chars, int idx) {
        while (idx < chars.length) {
            char c = chars[idx];
            if (c == '*') {
                if (dfs(new ArrayList<>(stack), chars, idx + 1)) {
                    return true;
                }
                ArrayList<Character> n = new ArrayList<>(stack);
                n.add('(');
                if (dfs(n, chars, idx + 1)) {
                    return true;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                stack.remove(stack.size() - 1);
                return dfs(stack, chars, idx + 1);
            }
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.remove(stack.size() - 1);
            }
            idx++;
        }
        return stack.isEmpty();
    }
}
