package com.carter.leet;

import java.util.*;

public class item2157 {
    public int[] groupStrings(String[] words) {
        //按题意,不关心字符顺序,且每个字符串中的字符唯一.所以将每一个字符串转换为数字,并记录出现次数
        Map<Integer, Integer> set = new HashMap<>();
        for (String w : words) {
            int hash = 0;
            for (int i = 0; i < w.length(); i++) {
                hash |= 1 << w.charAt(i) - 'a';
            }
            set.put(hash, set.getOrDefault(hash, 0) + 1);
        }
        int[] ans = new int[2];
        //BFS
        Queue<Integer> q = new ArrayDeque<>();
        while (set.size() > 0) {
            //组数量
            ans[0]++;
            //随便获取一个字符串,作为BFS起点
            Iterator<Map.Entry<Integer, Integer>> iterator = set.entrySet().iterator();
            Map.Entry<Integer, Integer> next = iterator.next();
            iterator.remove();
            q.offer(next.getKey());
            //当前组的字符串数量
            int cnt = next.getValue();
            while (q.size() > 0) {
                int poll = q.poll();
                //遍历a-z,如果字符串中存在,则可以删除或替换;不存在则可以添加
                for (int i = 0; i < 26; i++) {
                    int a = 1 << i;
                    if ((poll & a) > 0) {
                        //删除或替换一个字母
                        //先删除,再添加.如果添加的字符已经在字符串中存在,则为删除,否则为替换
                        int del = poll ^ a;
                        for (int j = 0; j < 26; j++) {
                            int b = 1 << j;
                            int t = del | b;
                            //数量
                            Integer c = set.remove(t);
                            if (c != null) {
                                q.offer(t);
                                cnt += c;
                            }
                        }
                    } else {
                        //添加一个字母
                        int add = poll | a;
                        Integer c = set.remove(add);
                        if (c != null) {
                            q.offer(add);
                            cnt += c;
                        }
                    }
                }
            }
            //更新字符串组的最大数量
            ans[1] = Math.max(ans[1], cnt);
        }
        return ans;
    }
}
