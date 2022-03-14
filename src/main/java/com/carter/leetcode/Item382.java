package com.carter.leetcode;

import com.carter.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item382 {
    class Solution {
        private final List<Integer> list = new ArrayList<>();
        private final Random random = new Random();

        public Solution(ListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
