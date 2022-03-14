package com.carter.leetcode;

import com.carter.ListNode;

public class Item5915 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        //第一个临界点
        Integer firstCriticalIdx = null;
        //上一个临界点下标
        int preCriticalIdx = -100000;
        //最小距离
        int min = 100000;
        //上一个元素值
        int pre = head.val;
        //从第二个节点开始遍历,如果是临界点,则加入临界点列表中
        head = head.next;
        int idx = 1;
        while (head.next != null) {
            //判断是否为临界点
            if ((head.val < pre && head.val < head.next.val) || (head.val > pre && head.val > head.next.val)) {
                //第一个临界点
                if (firstCriticalIdx == null) {
                    firstCriticalIdx = idx;
                }
                //计算最小距离
                if (idx - preCriticalIdx < min) {
                    min = idx - preCriticalIdx;
                }
                preCriticalIdx = idx;
            }
            pre = head.val;
            head = head.next;
            idx++;
        }
        if (firstCriticalIdx==null||firstCriticalIdx == preCriticalIdx) {
            //没有临界点,或第一个临界点和最后一个临界点相同,临界点数量小于2,返回 [-1，-1]
            return new int[]{-1, -1};
        }
        return new int[]{min, preCriticalIdx - firstCriticalIdx};
    }
}
