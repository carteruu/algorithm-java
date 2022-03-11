package com.carter.leet;

import java.util.*;

public class Item2025 {
    /**
     * 1. 先将pivot放在0前面
     * 2. 向右移动pivot,分别更新左右两边的和:
     * 1) 如果相等,不替换数字的答案+1
     * 2) 如果存在使用k替换某个数字后,左右两边和相等,则将对应的下标答案+1
     * 3. 对比出答案的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int waysToPartition3(int[] nums, int k) {
        //左右两边的和
        long sumL = 0;
        long sumR = 0;
        //左右两边存在的数字,及其所在的下标
        Map<Long, Set<Integer>> mapL = new HashMap<>();
        Map<Long, Set<Integer>> mapR = new HashMap<>();
        //先将所有数都放在右边,即pivot在0前面
        for (int i = 0; i < nums.length; i++) {
            sumR += nums[i];
            Long num = (long) nums[i];
            if (!mapR.containsKey(num)) {
                mapR.put(num, new HashSet<>());
            }
            mapR.get(num).add(i);
        }
        //注意题意,左右两边至少包含一个数字
        //不替换数字的答案
        int ans = 0;
        //替换每个下标i的数字后的答案
        int[] timesK = new int[nums.length];
        //替换某一个数字后,最大的答案
        int ansK = 0;
        for (int pivot = 0; pivot < nums.length - 1; pivot++) {
            //向右移动pivot
            //更新两边的和
            long num = nums[pivot];
            sumL = sumL + num;
            sumR = sumR - num;
            //更新两边包含的数字及下标
            if (!mapL.containsKey(num)) {
                mapL.put(num, new HashSet<>());
            }
            mapL.get(num).add(pivot);
            mapR.get(num).remove(pivot);
            //不改变任何数字
            if (sumL == sumR) {
                ans++;
            }
            //左右两边有哪些下标的数字,被替换后,可以使当前的pivot满足条件
            //满足条件的num:k-num==sumR-sumL => num==k-(sumR-sumL)
            for (Integer idx : mapL.getOrDefault(k - (sumR - sumL), new HashSet<>())) {
                //拿到num对应的下标,并将该下标的答案+1
                timesK[idx]++;
                ansK = Math.max(ansK, timesK[idx]);
            }
            //满足条件的num:k-num==sumL-sumR => num==k-(sumL-sumR)
            for (Integer idx : mapR.getOrDefault(k - (sumL - sumR), new HashSet<>())) {
                //拿到num对应的下标,并将该下标的答案+1
                timesK[idx]++;
                ansK = Math.max(ansK, timesK[idx]);
            }
        }
        return Math.max(ans, ansK);
    }

    /**
     * 1. 先将pivot放在0前面
     * 2. 向右移动pivot,记录右边和左边的差,及其对应的pivot
     * 3.
     *
     * @param nums
     * @param k
     * @return
     */
    public int waysToPartition4(int[] nums, int k) {
        int ans = 0;
        //记录pivot在每个可行位置时,左右两边的和
        Map<Long, List<Integer>> diffMap = new HashMap<>();
        long sumL = 0;
        long sumR = 0;
        for (int num : nums) {
            sumR += num;
        }
        for (int pivot = 0; pivot < nums.length - 1; pivot++) {
            //更新和
            sumL = sumL + nums[pivot];
            sumR = sumR - nums[pivot];
            //右边和左边的差
            long diff = sumR - sumL;
            if (!diffMap.containsKey(diff)) {
                diffMap.put(diff, new ArrayList<>());
            }
            //加入当前下边
            diffMap.get(diff).add(pivot);

            if (sumL == sumR) {
                ans++;
            }
        }
        //替换每个下标i的数字后的答案
        int[] timesK = new int[nums.length];
        //替换某一个数字后,最大的答案
        int ansK = 0;
        for (int i = 0; i < nums.length; i++) {
            //替换pivot左边的元素
            long diff = k - nums[i];
            for (int pivot : diffMap.getOrDefault(diff, new ArrayList<>())) {
                if (pivot >= i) {
                    timesK[i]++;
                    ansK = Math.max(ansK, timesK[i]);
                }
            }
            //替换pivot右边的元素
            diff = nums[i] - k;
            for (int pivot : diffMap.getOrDefault(diff, new ArrayList<>())) {
                if (pivot < i) {
                    timesK[i]++;
                    ansK = Math.max(ansK, timesK[i]);
                }
            }
        }
        return Math.max(ans, ansK);
    }

    public int waysToPartition(int[] nums, int k) {
        //先将pivot放在0前面,然后往右移动pivot,记录每个位置,左右两边的和
        long[][] sums = new long[nums.length - 1][2];
        long sumL = 0;
        long sumR = 0;
        for (int num : nums) {
            sumR += num;
        }
        int ans = 0;
        for (int pivot = 0; pivot < nums.length - 1; pivot++) {
            sumL = sumL + nums[pivot];
            sumR = sumR - nums[pivot];
            sums[pivot] = new long[]{sumL, sumR};
            if (sumL == sumR) {
                ans++;
            }
        }
        //遍历每一个数字,用k替换.然后统计替换后有多少个pivot满足两边和相等
        for (int i = 0; i < nums.length; i++) {
            int ansK = 0;
            for (int pivot = 0; pivot < nums.length - 1; pivot++) {
                long[] sum = sums[pivot];
                if (i <= pivot) {
                    //当前数字在pivot左边,修改左边和
                    if (sum[0] - nums[i] + k == sum[1]) {
                        ansK++;
                    }
                } else {
                    //当前数字在pivot右边,修改右边和
                    if (sum[0] == sum[1] - nums[i] + k) {
                        ansK++;
                    }
                }
            }
            ans = Math.max(ans, ansK);
        }
        return ans;
    }

    public int waysToPartition1(int[] nums, int k) {
        int ans = way(nums, 0, nums.length - 1, nums[0], nums[nums.length - 1]);
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = k;
            ans = Math.max(ans, way(nums, 0, nums.length - 1, nums[0], nums[nums.length - 1]));
            nums[i] = temp;
        }
        return ans;
    }

    private int way(int[] nums, int l, int r, int sumL, int sumR) {
        if (r - l == 1) {
            return sumL == sumR ? 1 : 0;
        }
        return way(nums, l, r - 1, sumL, sumR + nums[r - 1]) + way(nums, l + 1, r, sumL + nums[l + 1], sumR);
    }

    static class Solution {
        public int waysToPartition(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            Map<Integer, Integer> m1 = new HashMap<>();
            Map<Integer, Integer> m2 = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                preSum[i] = nums[i - 1] + preSum[i - 1];
                // 一开始除了最后一个前缀和，其余均在m2中
                if (i != n) {
                    m2.put(preSum[i], m2.getOrDefault(preSum[i], 0) + 1);
                }
            }
            int ans = 0;
            if (preSum[n] % 2 == 0) {
                // 若一个元素都不修改
                ans = m2.getOrDefault(preSum[n] / 2, 0);
            }
            for (int i = 0; i < n; i++) {
                // 修改下标为i的元素变成k
                int change = k - nums[i];
                // 所有元素总和的变化量也是change
                int pn = preSum[n] + change;
                if (pn % 2 == 0) {
                    // m1存的是,替换了数字后,没有影响的和. 在m1中我们要找的目标是 target1 = 总和/2 的数量
                    int t1 = pn / 2;
                    // m2存的是,替换了数字后,需要变化的和. 在m2中我们要找的目标是 target2 = target1 - change 的数量
                    int t2 = t1 - change;
                    int found = m1.getOrDefault(t1, 0) + m2.getOrDefault(t2, 0);
                    ans = Math.max(ans, found);
                }
                // 不断减少m2中的计数，增加m1对应的计数
                if (i != n - 1) {
                    m1.put(preSum[i + 1], m1.getOrDefault(preSum[i + 1], 0) + 1);
                    int tmp = m2.get(preSum[i + 1]);
                    if (tmp == 1) {
                        m2.remove(preSum[i + 1]);
                    } else {
                        m2.put(preSum[i + 1], tmp - 1);
                    }
                }
            }
            return ans;
        }

    }
}
