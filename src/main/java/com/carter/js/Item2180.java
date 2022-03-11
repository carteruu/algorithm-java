package com.carter.js;

public class Item2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int temp = i;
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if ((sum & 1) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
