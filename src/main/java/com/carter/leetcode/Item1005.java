package com.carter.leetcode;

public class Item1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] arr = new int[201];
        int sum = 0;
        for (int num : nums) {
            arr[num + 100]++;
            sum += num;
        }
        //从小到大,将负数变为正数
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < arr[i]; j++) {
                if (k == 0) {
                    break;
                }
                sum += 2 * (100 - i);
                k--;
            }
        }
        //如果所有负数都变为正数后,剩余的k为奇数,则需要将最小的非负数取反;否则直接返回sum
        //注意这里包含从负数取反后得到的正数
        if ((k & 1) == 1) {
            for (int i = 0; i <= 100; i++) {
                if (arr[100 - i] > 0 || arr[i + 100] > 0) {
                    sum -= 2 * i;
                    break;
                }
            }
        }
        return sum;
    }
}
