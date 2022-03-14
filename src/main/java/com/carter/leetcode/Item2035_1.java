package com.carter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item2035_1 {
    public int minimumDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int ans = Integer.MAX_VALUE;
        int n = nums.length / 2;
        List<Integer>[] l = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            l[i] = new ArrayList<>();
        }
        int times = (1 << n) - 1;
        for (int i = 0; i <= times; i++) {
            int sub = 0;
            for (int j = 0; j < n; j++) {
                if ((1 << j & i) > 0) {
                    sub += nums[j];
                }
            }
            l[Integer.bitCount(i)].add(sub);
        }
        //排序
        for (int i = 0; i <= n; i++) {
            Collections.sort(l[i]);
        }
        for (int i = 0; i <= times; i++) {
            int sub = 0;
            for (int j = 0; j < n; j++) {
                if ((1 << j & i) > 0) {
                    sub += nums[n + j];
                }
            }
            List<Integer> list = l[n - Integer.bitCount(i)];
            if (list.size() == 0) {
                continue;
            }
            int nearest = nearest(list, sum / 2 - sub);
            ans = Math.min(ans, Math.abs(sum - 2 * (sub + nearest)));
        }
        return ans;
    }

    /**
     * 二分查找,最接近的值
     *
     * @param list
     * @param num
     * @return
     */
    private int nearest(List<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
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
        public int minimumDifference(int[] nums) {
            int n = nums.length / 2;
            int sum = Arrays.stream(nums).sum();
            int[] A = new int[n], B = new int[n];
            List<List<Integer>> X = new ArrayList<>(), Y = new ArrayList<>();

            // 分割两个子集
            for (int i = 0; i <= n; i++) {
                if (i < n) {
                    A[i] = nums[i];
                    B[i] = nums[i + n];
                }
                X.add(new ArrayList<>());
                Y.add(new ArrayList<>());
            }

            // 进行组合枚举
            for (int mask = 0; mask < 1 << n; mask++) {
                int key = Integer.bitCount(mask);
                int cnt_a = 0, cnt_b = 0;
                for (int i = 0; i < n; i++) {
                    if (((mask >> i) & 1) == 1) {
                        cnt_a += A[i];
                        cnt_b += B[i];
                    }
                }
                X.get(key).add(cnt_a);
                Y.get(key).add(cnt_b);
            }

            // 将Y进行排序，以便二分查找
            for (int i = 0; i <= n; i++) {
                Collections.sort(Y.get(i));
            }

            // 进行二分查找答案
            int ans = Integer.MAX_VALUE;
            for (int k = 0; k <= n; k++) {
                List<Integer> x = X.get(k);
                List<Integer> y = Y.get(n - k);
                for (int i : x) {
                    int l = 0, r = y.size() - 1;
                    while (l < r) {
                        int mid = (r - l) / 2 + l;
                        int j = y.get(mid);
                        if (i + j < sum / 2) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                    ans = Math.min(ans, Math.abs((sum - i - y.get(l) - (i + y.get(l)))));
                }
            }
            return ans;
        }
    }
}
