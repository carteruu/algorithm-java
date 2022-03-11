package com.carter.leet;

import java.util.Arrays;

public class Item2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k || i + k >= nums.length) {
                ans[i] = -1;
            }
            if (i >= 2 * k) {
                ans[i - k] = (int) (sum / (2 * k + 1));
                sum -= nums[i - 2 * k];
            }
        }
        return ans;
    }

    public int[] getAverages1(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int[] ans = new int[nums.length];
        int len = 2 * k + 1;
        if (nums.length < len) {
            Arrays.fill(ans, -1);
            return ans;
        }
        //窗口内数字的和,用long避免溢出
        long sum = 0;
        for (int i = 0; i < k; i++) {
            //前k个答案都是-1
            ans[i] = -1;
            //后k个答案都是-1
            ans[ans.length - 1 - i] = -1;
            //计算下标从0到2k+1的和,不包含k
            sum += nums[i] + nums[k + 1 + i];
        }
        //加上下标为k的数
        sum += nums[k];
        //计算答案
        for (int i = k; i < nums.length - 1 - k; i++) {
            ans[i] = (int) (sum / len);
            //左边第一个数字,移出窗口
            sum -= nums[i - k];
            //移入右边的下一个数字
            sum += nums[i + k + 1];
        }
        //最后一个答案
        ans[nums.length - 1 - k] = (int) (sum / len);
        return ans;
    }
}
