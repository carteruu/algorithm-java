package com.carter.offer;

import com.carter.ListNode;

import java.util.ArrayList;

public class Item06 {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int[] ans = new int[n];
        while (head != null) {
            ans[--n] = head.val;
            head = head.next;
        }
        return ans;
    }

    public int[] reversePrint1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[ans.length - 1 - i] = list.get(i);
        }
        return ans;
    }
}
