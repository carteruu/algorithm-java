package com.carter.leet;

import java.util.*;

public class Item373 {
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k);
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                ans.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }
        ans.sort(Comparator.comparingInt(item -> item.get(0) + item.get(1)));
        int len = Math.min(ans.size(), k);
        return ans.subList(0, len);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(nums1.length,
                Comparator.comparingInt(item -> nums1[item[0]] + nums2[item[1]]));
        for (int i = 0; i < nums1.length; i++) {
            minHeap.offer(new int[]{i, 0});
        }
        for (int i = 0; i < k && minHeap.size() > 0; i++) {
            int[] poll = minHeap.poll();
            ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            poll[1]++;
            if (poll[1] < nums2.length) {
                minHeap.offer(poll);
            }
        }
        return ans;
    }

    class Solution {
        int[] nums1, nums2;
        int n, m;

        public List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
            nums1 = n1;
            nums2 = n2;
            n = nums1.length;
            m = nums2.length;
            List<List<Integer>> ans = new ArrayList<>();
            int l = nums1[0] + nums2[0],
                    r = nums1[n - 1] + nums2[m - 1];
            while (l < r) {
                int mid = l + r >> 1;
                if (check(mid, k)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int x = r;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (nums1[i] + nums2[j] < x) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums1[i]);
                        temp.add(nums2[j]);
                        ans.add(temp);
                    } else {
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int a = nums1[i], b = x - a;
                int c = -1, d = -1;
                l = 0;
                r = m - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (nums2[mid] >= b) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                if (nums2[r] != b) {
                    continue;
                }
                c = r;
                l = 0;
                r = m - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (nums2[mid] <= b) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                d = r;
                for (int p = c; p <= d && ans.size() < k; p++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]);
                    temp.add(nums2[p]);
                    ans.add(temp);
                }
            }
            return ans;
        }

        boolean check(int x, int k) {
            int ans = 0;
            for (int i = 0; i < n && ans < k; i++) {
                for (int j = 0; j < m && ans < k; j++) {
                    if (nums1[i] + nums2[j] <= x) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
            return ans >= k;
        }
    }
}
