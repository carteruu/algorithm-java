package com.carter.leet;

import java.util.*;

public class Item911 {

    static class TopVotedCandidate {
        private final int[] ans;
        private final int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            int n = persons.length;
            this.ans = new int[n];
            this.times = times;
            int[] preSum = new int[n];
            int[] lastVote = new int[n];
            PriorityQueue<Integer> idx = new PriorityQueue<>((o1, o2) -> {
                if (preSum[o1] == preSum[o2]) {
                    return lastVote[o2] - lastVote[o1];
                }
                return preSum[o2] - preSum[o1];
            });
            Arrays.fill(lastVote, -1);
            for (int i = 0; i < n; i++) {
                lastVote[persons[i]] = i;
                preSum[persons[i]]++;
                idx.remove(persons[i]);
                idx.offer(persons[i]);
                if (i > 0 && idx.peek() != this.ans[i - 1] && preSum[idx.peek()] <= preSum[this.ans[i - 1]]) {
                    idx.offer(this.ans[i - 1]);
                }
                this.ans[i] = idx.poll();
            }
        }

        public int q(int t) {
            //二分查找小于等于t的最近时间
            int l = 0;
            int r = this.times.length - 1;
            int ans = l;
            while (l <= r) {
                int mid = (r + l) >> 1;
                if (this.times[mid] > t) {
                    r = mid - 1;
                } else if (this.times[mid] < t) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    return this.ans[mid];
                }
            }
            return this.ans[ans];
        }
    }
}
