package com.carter.js;

public class Item2169 {
    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 != 0 && num2 != 0) {
            int b = Math.max(num1, num2);
            int l = Math.min(num1, num2);
            int d = b - l;

            num1 = Math.max(l, d);
            num2 = Math.min(l, d);
            ans++;
        }
        return ans;
    }
}
