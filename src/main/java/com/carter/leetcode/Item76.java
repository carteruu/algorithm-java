package com.carter.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Item76 {
    /**
     * 使用一个数字存t的字符数量
     * 使用一个数组存滑动窗口的字符数量:
     * 如果不满足条件,窗口右边界向右移动,扩大窗口;
     * 如果满足条件,更新答案,同时左边界向左移动,缩小窗口;
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int m = t.length();
        int n = s.length();

        int left = 0;
        int right = 0;
        int andLeft = -1;
        int andRight = n;
        int len = 'z' - 'A' + 1;
        //存t的字符数量
        int[] tCount = new int[len];
        for (char c : t.toCharArray()) {
            tCount[c - 'A']++;
        }
        //存[left,right]窗口的字符数量
        int[] sCount = new int[len];
        while (right < n) {
            //right往右移动,增大窗口,并更新temp的字符数量,减少m的值
            int idxRight = s.charAt(right) - 'A';
            if (sCount[idxRight] < tCount[idxRight]) {
                //需要的字符移入窗口时,m减小
                m--;
            }
            sCount[idxRight]++;

            while (left < n && m == 0) {
                //m为0时,找到所有需要的字符.增大left的值,减小窗口
                if (right - left < andRight - andLeft) {
                    //更新答案
                    andLeft = left;
                    andRight = right;
                }
                int idxLeft = s.charAt(left) - 'A';
                if (sCount[idxLeft] <= tCount[idxLeft]) {
                    //需要的字符被移出窗口时,m增大
                    m++;
                }
                sCount[idxLeft]--;
                left++;
            }
            right++;
        }
        return andLeft < 0 ? "" : s.substring(andLeft, andRight + 1);
    }

    public String minWindow2(String s, String t) {
        int m = t.length();
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> temp = new HashMap<>();
        int left = 0;
        int right = 0;
        String res = null;
        while (left < n) {
            while (m > 0 && right < n) {
                if (map.containsKey(s.charAt(right))) {
                    if (temp.getOrDefault(s.charAt(right), 0) < map.get(s.charAt(right))) {
                        //找到需要的字符
                        m--;
                    }
                    temp.put(s.charAt(right), temp.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            }
            if (m == 0) {
                if (res == null || res.length() > right - left) {
                    res = s.substring(left, right);
                }
            }
            if (map.containsKey(s.charAt(left))) {
                if (temp.get(s.charAt(left)) <= map.get(s.charAt(left))) {
                    m++;
                }
                temp.put(s.charAt(left), temp.get(s.charAt(left)) - 1);
            }
            left++;
        }
        return res == null ? "" : res;
    }
}

class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}