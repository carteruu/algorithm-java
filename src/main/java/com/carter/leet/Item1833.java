package com.carter.leet;

import java.util.Arrays;

public class Item1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int rs = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            coins -= cost;
            rs++;
        }
        return rs;
    }

    /**
     * 计数排序
     *
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream1(int[] costs, int coins) {
        int max = 0;
        for (int x : costs) {
            if (x > max) max = x;
        }
        int[] arr = new int[max + 1];
        for (int x : costs) arr[x]++;
        int sum = 0, count = 0;
        for (int i = 1; i <= max; i++) {
            if (arr[i] > 0) {
                if (arr[i] * i + sum < coins) {
                    sum += arr[i] * i;
                    count += arr[i];
                } else {
                    count += (coins - sum) / i;
                    break;
                }
            }
        }
        return count;
    }
}
