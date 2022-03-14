package com.carter.leetcode;

public class Item2170 {
    public int minimumOperations(int[] nums) {
        int odd1 = 0;
        int odd2 = 0;
        int even1 = 0;
        int even2 = 0;
        int[] oddCnt = new int[100001];
        int[] evenCnt = new int[100001];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((i & 1) == 1) {
                //奇数下标
                oddCnt[num]++;
                if (num != odd1 && (odd1 == 0 || oddCnt[num] > oddCnt[odd1])) {
                    odd2 = odd1;
                    odd1 = num;
                }
                if (num != odd1 && (odd2 == 0 || oddCnt[num] > oddCnt[odd2])) {
                    odd2 = num;
                }
            } else {
                evenCnt[num]++;
                if (num != even1 && (even1 == 0 || evenCnt[num] > evenCnt[even1])) {
                    even2 = even1;
                    even1 = num;
                }
                if (num != even1 && (even2 == 0 || evenCnt[num] > evenCnt[even2])) {
                    even2 = num;
                }
            }
        }
        if (odd1 != even1) {
            return nums.length - oddCnt[odd1] - evenCnt[even1];
        } else {
            return nums.length - (Math.max(oddCnt[odd1] + evenCnt[even2], oddCnt[odd2] + evenCnt[even1]));
        }
    }
}
