package com.carter.leetcode;

public class Item2164 {
    public int[] sortEvenOdd(int[] nums) {
        int m = 101;
        //偶数
        int[] evenCnt = new int[m];
        //奇数
        int[] oddCnt = new int[m];
        int n = nums.length;
        for (int i = 0; i < n; i += 2) {
            evenCnt[nums[i]]++;
            if (i + 1 < n) {
                oddCnt[nums[i + 1]]++;
            }
        }
        int[] ans = new int[n];
        int evenIdx = 0;
        //n为偶数时,最后一个奇数下标为n-1;为奇数时,为n-2
        int oddIdx = (n & 1) == 0 ? n - 1 : n - 2;
        for (int i = 0; i < m; i++) {
            //偶数,非递增
            while (evenCnt[i] > 0) {
                ans[evenIdx] = i;
                evenIdx += 2;
                evenCnt[i]--;
            }
            //奇数,非递减
            while (oddCnt[i] > 0) {
                ans[oddIdx] = i;
                oddIdx -= 2;
                oddCnt[i]--;
            }
        }
        return ans;
    }
}
