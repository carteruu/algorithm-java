package com.carter.leet;

public class Item1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int ans = 0;
        for (int k = 30; k > 0; k--) {
            int count1 = 0;
            int count2 = 0;
            for (int num1 : arr1) {
                if ((num1 & (1 << k)) > 0) {
                    count1++;
                }
            }
            for (int num2 : arr2) {
                if ((num2 & (1 << k)) > 0) {
                    count2++;
                }
            }
            if (count1 % 2 == 1 && count2 % 2 == 1) {
                ans |= 1 << k;
            }
        }
        return ans;
    }

    public int getXORSum2(int[] arr1, int[] arr2) {
        int a1 = 0;
        for (int j : arr1) {
            a1 ^= j;
        }
        int a2 = 0;
        for (int j : arr2) {
            a2 ^= j;
        }
        return a1 & a2;
    }

    public int getXORSum1(int[] arr1, int[] arr2) {
        int rs = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                rs ^= (arr1[i] & arr2[j]);
            }
        }
        return rs;
    }
}
