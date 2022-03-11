package com.carter.leet;

import java.util.Map;
import java.util.TreeMap;

public class Item2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int l = 0, r = 0, sum = 0, max = 0;
        int leftBound = startPos - k, rightBound = startPos + k;
        for (; r < fruits.length; r++) {
            if (fruits[r][0] > rightBound) {
                break;
            }
            if (fruits[r][0] < leftBound) {
                l++;
            } else {
                sum += fruits[r][1];
                while (Math.min(2 * (startPos - fruits[l][0]) + (fruits[r][0] - startPos),
                        startPos - fruits[l][0] + 2 * (fruits[r][0] - startPos)) > k) {
                    //判断是否合理
                    sum -= fruits[l][1];
                    l++;
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public int maxTotalFruits4(int[][] fruits, int startPos, int k) {
        int left = this.findStart(fruits, startPos, k);
        int right = left;
        int sum = 0;
        int ans = 0;
        while (left < fruits.length && (left == 0 || fruits[left - 1][0] <= startPos)) {
            while (right < fruits.length && (fruits[right][0] < startPos || Math.min(startPos - fruits[left][0], fruits[right][0] - startPos) * 2 + Math.max(startPos - fruits[left][0], fruits[right][0] - startPos) <= k)) {
                sum += fruits[right][1];
                right++;
            }
            ans = Math.max(ans, sum);
            sum -= fruits[left][1];
            left++;
        }
        return ans;
    }

    private int findStart(int[][] fruits, int startPos, int k) {
        int l = 0;
        int r = fruits.length - 1;
        int startIdx = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (startPos - fruits[mid][0] > k) {
                l = mid + 1;
            } else if (startPos - fruits[mid][0] < k) {
                startIdx = mid;
                r = mid - 1;
            } else {
                startIdx = mid;
                break;
            }
        }
        return startIdx;
    }

    public int maxTotalFruits2(int[][] fruits, int startPos, int k) {
        int max = (int) 2e5;
        int[] preSum = new int[max + 2];
        int idx = 0;
        int sum = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (idx < fruits.length && i == fruits[idx][0]) {
                sum += fruits[idx][1];
                idx++;
            }
            preSum[i] = sum;
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            int l = Math.max(0, startPos - i);
            int r = Math.min(max, l + k - i);
            ans = Math.max(ans, preSum[r] - (l == 0 ? 0 : preSum[l - 1]));

            r = Math.min(max, startPos + i);
            l = Math.max(0, r - (k - i));
            ans = Math.max(ans, preSum[r] - (l == 0 ? 0 : preSum[l - 1]));
        }
        return ans;
    }

    /**
     * TODO 超时
     *
     * @param fruits
     * @param startPos
     * @param k
     * @return
     */
    public int maxTotalFruits1(int[][] fruits, int startPos, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] fruit : fruits) {
            map.put(fruit[0], fruit[1]);
        }
        Integer remove = map.remove(startPos);
        Map.Entry<Integer, Integer> l = map.lowerEntry(startPos);
        if (l != null) {
            map.remove(l.getKey());
        }
        Map.Entry<Integer, Integer> r = map.higherEntry(startPos);
        if (r != null) {
            map.remove(r.getKey());
        }
        return dfs(map, startPos, k, l, r) + (remove != null ? remove : 0);
    }

    private int dfs(TreeMap<Integer, Integer> map, int pos, int k, Map.Entry<Integer, Integer> l, Map.Entry<Integer, Integer> r) {
        int ans = 0;
        //往左
        if (l != null && pos - l.getKey() <= k) {
            Map.Entry<Integer, Integer> left = map.lowerEntry(l.getKey());
            if (left != null) {
                map.remove(left.getKey());
                ans = Math.max(ans, dfs(map, l.getKey(), k - pos + l.getKey(), left, r) + l.getValue());
                map.put(left.getKey(), left.getValue());
            } else {
                ans = Math.max(ans, dfs(map, l.getKey(), k - pos + l.getKey(), left, r) + l.getValue());
            }
        }
        //往右
        if (r != null && r.getKey() - pos <= k) {
            Map.Entry<Integer, Integer> right = map.higherEntry(pos);
            if (right != null) {
                map.remove(right.getKey());
                ans = Math.max(ans, dfs(map, r.getKey(), k - r.getKey() + pos, l, right) + r.getValue());
                map.put(right.getKey(), right.getValue());
            } else {
                ans = Math.max(ans, dfs(map, r.getKey(), k - r.getKey() + pos, l, right) + r.getValue());
            }
        }
        return ans;
    }

    class Solution {

        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int max = 0;
            for (int l = 0, r = l, sum = 0; l < fruits.length; sum -= fruits[l][1], l++) {
                while (r < fruits.length && 2 * Math.max(0, startPos - fruits[l][0]) + Math.max(0, fruits[r][0] - startPos) <= k) {
                    max = Math.max(max, sum += fruits[r++][1]);
                }
            }
            for (int r = fruits.length - 1, l = r, sum = 0; r >= 0; sum -= fruits[r][1], r--) {
                while (l >= 0 && 2 * Math.max(0, fruits[r][0] - startPos) + Math.max(0, startPos - fruits[l][0]) <= k) {
                    max = Math.max(max, sum += fruits[l--][1]);
                }
            }
            return max;
        }
    }

}
