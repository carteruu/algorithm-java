package com.carter.leet;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Item173 {
    public static class BSTIterator {
        private final Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            helper(root, list);
            iterator = list.iterator();
        }

        private void helper(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
