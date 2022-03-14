package com.carter.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class Item331 {
    // 方法1: 递归
    int pos = 0, n = 0;

    public boolean dfs(String s) {      //dfs递归按前序顺序(根左右)建树
        if (pos >= n) return false;      //递归有两个出口，越界返回false, s[pos] =='#'代表空节点，自然为true
        if (s.charAt(pos) == '#') {
            pos += 2;       //因为有逗号，故应加2
            return true;
        }
        while (pos < n && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') pos++;   //对当前节点访问只需要读数移动pos即可
        pos++;    //同样跳过逗号
        if (!dfs(s)) return false;  //对左右节点dfs建树，若有任意节点建树不成功，则代表整个序列不合法
        if (!dfs(s)) return false;
        return true;
    }

    public boolean isValidSerialization(String preorder) {
        n = preorder.length();
        return dfs(preorder) && pos >= n;  //成功建树且序列无多余节点才算合格
    }

    public boolean isValidSerialization1(String preorder) {
        String[] nodeVal = preorder.split(",");
        if ((nodeVal.length & 1) != 1) {
            return false;
        }
        AtomicInteger i = new AtomicInteger(0);
        return helper(nodeVal, i) && i.get() == nodeVal.length;
    }

    private boolean helper(String[] values, AtomicInteger i) {
        if (i.get() == values.length) {
            return false;
        }
        String value = values[i.getAndIncrement()];
        if ("#".equals(value)) {
            return true;
        }
        return helper(values, i) && helper(values, i);
    }
}
