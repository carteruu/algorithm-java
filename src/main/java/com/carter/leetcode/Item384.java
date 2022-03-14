package com.carter.leetcode;

import java.util.Random;

public class Item384 {
    class Solution {
        private int[] nums;
        private int[] shuffle;

        public Solution(int[] nums) {
            this.nums = nums;
            this.shuffle = nums.clone();
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < this.shuffle.length; i++) {
                int j = i + random.nextInt(this.shuffle.length - i);
                int temp = this.shuffle[i];
                this.shuffle[i] = this.shuffle[j];
                this.shuffle[j] = temp;
            }
            return this.shuffle;
        }
    }
}
