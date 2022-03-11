package com.carter.leet;

import java.util.Deque;
import java.util.LinkedList;

public class Item32 {

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int preIdx = i - dp[i - 1] - 1;
                    if (preIdx >= 0 && chars[preIdx] == '(') {
                        dp[i] = dp[i - 1] + 2 + (preIdx - 1 > 0 ? dp[preIdx - 1] : 0);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public int longestValidParentheses5(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public int longestValidParentheses4(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses3(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses2(String s) {
        int l = 0, r = 0;
        int ans = 0;
        int state = 0;
        char[] chars = s.toCharArray();
        while (l < chars.length) {
            while (r < chars.length && state >= 0) {
                if (chars[r] == '(') {
                    state++;
                } else {
                    state--;
                }
                if (state == 0) {
                    ans = Math.max(ans, r - l + 1);
                }
                r++;
            }
            if (chars[l] == '(') {
                state--;
            } else {
                state++;
            }
            l++;
        }
        return ans;
    }

    public int longestValidParentheses1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int state = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    state--;
                } else {
                    state++;
                }
                if (state == 0) {
                    ans = Math.max(ans, j - i + 1);
                } else if (state < 0) {
                    break;
                }
            }
        }
        return ans;
    }
}
