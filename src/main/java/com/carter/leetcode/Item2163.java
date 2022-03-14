package com.carter.leetcode;


import java.util.*;

public class Item2163 {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 3;
        long ans = Long.MAX_VALUE;
        //大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //前缀最小和
        long[] leftPreSum = new long[n * 2 + 1];
        for (int i = 0; i < n * 2; i++) {
            maxHeap.offer(nums[i]);
            leftPreSum[i + 1] = leftPreSum[i] + nums[i];
            if (maxHeap.size() > n) {
                leftPreSum[i + 1] -= maxHeap.poll();
            }
        }
        //小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //后缀最小和
        long rightSum = 0;
        for (int i = m - 1; i >= n; i--) {
            rightSum += nums[i];
            minHeap.offer(nums[i]);
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                ans = Math.min(ans, leftPreSum[i] - rightSum);
            }
        }
        return ans;
    }

    public long minimumDifference3(int[] nums) {
        long[] left = new long[nums.length + 1];
        long[] right = new long[nums.length + 1];
        long min = Long.MAX_VALUE;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(),
                rightQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            leftQueue.offer(-nums[i]);
            left[i + 1] = left[i] + nums[i] + (leftQueue.size() > nums.length / 3 ? leftQueue.poll() : 0);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            rightQueue.offer(nums[i]);
            right[i] = right[i + 1] + nums[i] - (rightQueue.size() > nums.length / 3 ? rightQueue.poll() : 0);
        }
        for (int i = nums.length / 3; i <= 2 * nums.length / 3; i++) {
            min = Math.min(min, left[i] - right[i]);
        }
        return min;
    }

    public long minimumDifference2(int[] nums) {
        int n = nums.length;
        long leftSum = 0;
        long rightSum = 0;
        //大顶堆
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n / 3; i++) {
            leftSum += nums[i];
            leftHeap.add(nums[i]);
        }
        //小顶堆
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        Map<Integer, Integer> rightCnt = new HashMap<>();
        for (int i = n / 3; i < n; i++) {
            rightSum += nums[i];
            rightHeap.add(nums[i]);
            rightCnt.put(nums[i], rightCnt.getOrDefault(nums[i], 0) + 1);
        }
        long ans = Long.MAX_VALUE;
        for (int i = n / 3; i <= n / 3 * 2; i++) {
            List<Integer> save = new ArrayList<>(rightHeap.size() - n / 3);
            while (rightHeap.size() > n / 3) {
                Integer poll = rightHeap.poll();
                rightSum -= poll;
                save.add(poll);
            }
            ans = Math.min(ans, leftSum - rightSum);
            //还原
            for (Integer num : save) {
                rightHeap.add(num);
                rightSum += num;
            }
            rightHeap.remove(nums[i]);
            rightSum -= nums[i];

            leftSum += nums[i];
            leftHeap.add(nums[i]);
            leftSum -= leftHeap.poll();
        }
        return ans;
    }

    private final Map<String, Long> cache = new HashMap<>();

    public long minimumDifference1(int[] nums) {
        long leftSum = 0;
        long rightSum = 0;
        //大顶堆
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //小顶堆
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n / 3; i++) {
            leftSum += nums[i];
            leftHeap.add(nums[i]);
            rightSum += nums[n - 1 - i];
            rightHeap.add(nums[n - 1 - i]);
        }
        return dfs(nums, leftSum, rightSum, leftHeap, rightHeap, n / 3, n - 1 - n / 3);
    }

    private long dfs(int[] nums, long leftSum, long rightSum, PriorityQueue<Integer> leftHeap, PriorityQueue<Integer> rightHeap, int left, int right) {
        if (left > right) {
            return leftSum - rightSum;
        }
        String key = left + "-" + right;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        leftHeap.add(nums[left]);
        int poll = leftHeap.poll();
        long l = dfs(nums, leftSum + nums[left] - poll, rightSum, leftHeap, rightHeap, left + 1, right);
        leftHeap.add(poll);
        leftHeap.remove(nums[left]);

        rightHeap.add(nums[right]);
        poll = rightHeap.poll();
        long r = dfs(nums, leftSum, rightSum + nums[right] - poll, leftHeap, rightHeap, left, right - 1);
        rightHeap.add(poll);
        rightHeap.remove(nums[right]);
        long rt = Math.min(l, r);
        cache.put(key, rt);
        return rt;
    }
}
