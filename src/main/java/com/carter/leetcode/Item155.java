package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Item155 {
    public static class MinStack {
        private final Deque<Integer> queue;
        private final Deque<Integer> minQueue;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            queue = new ArrayDeque<>();
            minQueue = new ArrayDeque<>();
        }

        public void push(int val) {
            queue.push(val);
            if (minQueue.isEmpty() || val <= minQueue.peek()) {
                minQueue.push(val);
            }
        }

        public void pop() {
            Integer pop = queue.pop();
            if (pop.equals(minQueue.peek())) {
                minQueue.pop();
            }
        }

        public int top() {
            return queue.peek();
        }

        public int getMin() {
            return minQueue.peek();
        }
    }

}
