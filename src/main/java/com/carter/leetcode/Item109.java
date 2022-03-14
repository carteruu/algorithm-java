package com.carter.leetcode;

import com.carter.ListNode;
import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Item109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return bst(list, 0, list.size() - 1);
    }

    private TreeNode bst(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int nodeIdx = (end - start) / 2 + start;
        TreeNode node = new TreeNode(list.get(nodeIdx));
        node.left = bst(list, start, nodeIdx - 1);
        node.right = bst(list, nodeIdx + 1, end);
        return node;
    }
}
