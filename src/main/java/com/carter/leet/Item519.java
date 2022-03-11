package com.carter.leet;

import java.util.*;

public class Item519 {
    public static class Solution {
        private int l = 0;
        private final int n;
        private final int cnt;
        private final Map<Integer, Integer> map;
        private final Random random;

        public Solution(int m, int n) {
            this.n = n;
            this.cnt = m * n;
            this.map = new HashMap<>(1000);
            this.random = new Random();
        }

        public int[] flip() {
            int nextPos = this.l + this.random.nextInt(this.cnt - this.l);
            int next = map.getOrDefault(nextPos, nextPos);
            this.map.put(nextPos, this.map.getOrDefault(this.l, this.l));
            this.l++;
            return new int[]{next / this.n, next % this.n};
        }

        public void reset() {
            this.l = 0;
            this.map.clear();
        }
    }

    public static class Solution1 {
        private Set<Integer> set;
        private int[] arr;
        private final Random random;
        private final int n;
        private final int cnt;
        private int left;

        private final boolean useSet;

        public Solution1(int m, int n) {
            this.n = n;
            this.cnt = m * n;
            this.left = 0;
            this.random = new Random();
            this.useSet = m * n > 10000;

            if (this.useSet) {
                this.set = new HashSet<>(1000);
            } else {
                this.arr = new int[this.cnt];
                for (int i = 0; i < this.cnt; i++) {
                    this.arr[i] = i;
                }
            }
        }

        public int[] flip() {
            int[] ans;
            if (this.useSet) {
                int i;
                do {
                    i = this.random.nextInt(this.cnt);
                } while (this.set.contains(i));
                this.set.add(i);
                return new int[]{i / this.n, i % this.n};
            } else {
                int i = this.random.nextInt(this.cnt - this.left) + this.left;
                int choose = this.arr[i];
                ans = new int[]{choose / this.n, choose % this.n};

                this.arr[i] = this.arr[this.left];
                this.arr[this.left] = choose;
                left++;
            }
            return ans;
        }

        public void reset() {
            if (this.useSet) {
                this.set.clear();
            } else {
                this.left = 0;
                for (int i = 0; i < this.cnt; i++) {
                    this.arr[i] = i;
                }
            }
        }
    }
}
