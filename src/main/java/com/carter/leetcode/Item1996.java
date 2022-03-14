package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Item1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        //按攻击从小到大,防御从大到小排序
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]));
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int[] p : properties) {
            while (!st.isEmpty() && st.peek() < p[1]) {
                st.pop();
                ans++;
            }
            st.push(p[1]);
        }
        return ans;
    }

    public int numberOfWeakCharacters2(int[][] properties) {
        int ans = 0;
        //按攻击从大到小,防御从小到大排序
        Arrays.sort(properties, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0];
        });
        int defenseMax = Integer.MIN_VALUE;
        for (int[] p : properties) {
            if (p[1] < defenseMax) {
                ans++;
            } else {
                defenseMax = p[1];
            }
        }
        return ans;
    }

    /**
     * 排序+分组遍历
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters1(int[][] properties) {
        int ans = 0;
        //按攻击倒序排序
        Arrays.sort(properties, (p1, p2) -> p2[0] - p1[0]);
        //将攻击相同的角色,分为同一组.attack为当前组的攻击.
        int attack = Integer.MIN_VALUE;
        //防御最大值
        int defenseMax = Integer.MIN_VALUE;
        //组内防御最大值
        int defenseMaxGroup = Integer.MIN_VALUE;
        //从攻击高到小的顺序遍历
        for (int[] property : properties) {
            if (property[0] != attack) {
                //攻击力不相同,进入下一组.更新当前组的攻击,,
                attack = property[0];
                //更新防御最大值
                defenseMax = Math.max(defenseMax, defenseMaxGroup);
            }
            //更新组内防御最大值
            defenseMaxGroup = Math.max(defenseMaxGroup, property[1]);
            if (property[1] < defenseMax) {
                //防御小于最大值即为弱角色
                ans++;
            }
        }
        return ans;
    }
}
