package com.carter.off;

import java.util.*;

public class Item59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>(ans.length);
        int l = 0, r = 0;
        while (r < nums.length) {
            while (q.size() > 0 && nums[r] > q.getLast()) {
                q.removeLast();
            }
            q.addLast(nums[r]);
            r++;
            if (r < k) {
                continue;
            }

            ans[r - k] = q.getFirst();
            if (q.getFirst() == nums[l]) {
                q.removeFirst();
            }
            l++;
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        Deque<Integer> q = new ArrayDeque<>(k);
        int l = 0, r = 0;
        while (r < k) {
            while (q.size() > 0 && nums[r] > q.getLast()) {
                q.removeLast();
            }
            q.addLast(nums[r]);
            r++;
        }
        int[] ans = new int[nums.length - k + 1];
        while (r < nums.length) {
            ans[r - k] = q.getFirst();
            while (q.size() > 0 && nums[r] > q.getLast()) {
                q.removeLast();
            }
            q.addLast(nums[r]);
            if (q.getFirst() == nums[l]) {
                q.removeFirst();
            }
            l++;
            r++;
        }
        ans[r - k] = q.getFirst();
        return ans;
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }

    static class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<Integer>();
            for (int i = 0; i < k; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            int[] ans = new int[n - k + 1];
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }
    }

    static class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] prefixMax = new int[n];
            int[] suffixMax = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i % k == 0) {
                    prefixMax[i] = nums[i];
                } else {
                    prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
                }
            }
            for (int i = n - 1; i >= 0; --i) {
                if (i == n - 1 || (i + 1) % k == 0) {
                    suffixMax[i] = nums[i];
                } else {
                    suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
                }
            }

            int[] ans = new int[n - k + 1];
            for (int i = 0; i <= n - k; ++i) {
                ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
            }
            return ans;
        }
    }

}
