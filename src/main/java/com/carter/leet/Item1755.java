package com.carter.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Item1755 {
    private int ans = Integer.MAX_VALUE;

    public int minAbsDifference(int[] nums, int goal) {
        if (nums.length == 1) {
            return Math.min(Math.abs(goal), Math.abs(goal - nums[0]));
        }
        List<Integer> middle = new ArrayList<>(1 << (nums.length / 2 - 1));
        dfs(nums, 0, 0, middle);
        Collections.sort(middle);
        dfs1(nums, nums.length / 2, 0, goal, middle);
        return ans;
    }

    /**
     * 回溯,获得所有可能的子集和
     *
     * @param nums
     * @param idx    当前处理的下标
     * @param subSum 子集和
     * @param middle 数组的前一半数字能组成的子集和
     */
    private void dfs(int[] nums, int idx, int subSum, List<Integer> middle) {
        if (idx == nums.length / 2) {
            middle.add(subSum);
            return;
        }
        dfs(nums, idx + 1, subSum, middle);
        dfs(nums, idx + 1, subSum + nums[idx], middle);
    }

    /**
     * 处理数组的后一半
     * 回溯,找出
     *
     * @param nums
     * @param idx    当前处理的下标
     * @param subSum 子集和
     * @param goal   目标值
     * @param middle 数组的前一半数字能组成的子集和
     */
    private void dfs1(int[] nums, int idx, int subSum, int goal, List<Integer> middle) {
        if (idx == nums.length) {
            int nearest = nearest(middle, 0, middle.size() - 1, goal - subSum);
            ans = Math.min(ans, Math.abs(goal - subSum - nearest));
            return;
        }
        dfs1(nums, idx + 1, subSum, goal, middle);
        dfs1(nums, idx + 1, subSum + nums[idx], goal, middle);
    }

    /**
     * 二分查找,最接近的值
     *
     * @param list
     * @param l
     * @param r
     * @param num
     * @return
     */
    private int nearest(List<Integer> list, int l, int r, int num) {
        int ans = list.get(l);
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            Integer m = list.get(mid);
            if (Math.abs(ans - num) > Math.abs(m - num)) {
                ans = m;
            }
            if (m > num) {
                r = mid - 1;
            } else if (m < num) {
                l = mid + 1;
            } else {
                return num;
            }
        }
        return ans;
    }

    public static class Solution {
        private int[] aux;

        public int minAbsDifference(int[] nums, int goal) {
            int n = nums.length, min = Integer.MAX_VALUE;
            aux = new int[1 << ((n + 1) / 2)];
            int[] sum1 = sum(nums, 0, n / 2);
            int[] sum2 = sum(nums, n / 2, (n + 1) / 2);

            for (int i = 0, j = sum2.length - 1; i < sum1.length && j >= 0; ) {
                int diff = sum1[i] + sum2[j] - goal;
                min = Math.min(min, Math.abs(diff));
                if (diff > 0) {
                    j--;
                } else if (diff < 0) {
                    i++;
                } else {
                    return min;
                }
            }
            return min;
        }

        private int[] sum(int[] nums, int from, int len) {
            int[] sum = new int[1 << len];
            sum[0] = 0;
            for (int id = 0; id < len; id++) {
                int i = 0, j = 0, k = 0, count = 1 << id;
                while (i < count || j < count) {
                    if (i == count) {
                        aux[k++] = sum[j++] + nums[from + id];
                    } else if (j == count) {
                        aux[k++] = sum[i++];
                    } else if (sum[i] <= sum[j] + nums[from + id]) {
                        aux[k++] = sum[i++];
                    } else {
                        aux[k++] = sum[j++] + nums[from + id];
                    }
                }
                System.arraycopy(aux, 0, sum, 0, 1 << len);
            }
            return sum;
        }
    }

}
