package com.carter.leetcode;

import java.util.*;

public class Item488 {
    public int findMinStep(String board, String hand) {
        //已经访问过的组合
        Set<String> seen = new HashSet<>();
        //队列[桌上的球,手上的球]
        Queue<String[]> queue = new ArrayDeque<>();
        queue.add(new String[]{board, hand});
        //球数
        int cnt = 0;
        while (queue.size() > 0) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //从队头拿出一个组合
                String[] poll = queue.poll();
                for (int hIdx = 0; hIdx < poll[1].length(); hIdx++) {
                    //从手里取出一个球,生成新的手里的球
                    String nh = poll[1].substring(0, hIdx) + poll[1].substring(hIdx + 1);
                    //插入桌上球的每个间隙,注意闭区间
                    for (int bIdx = 0; bIdx <= poll[0].length(); bIdx++) {
                        //插入,生成新的桌上的球
                        String nb = poll[0].substring(0, bIdx) + poll[1].charAt(hIdx) + poll[0].substring(bIdx);
                        //判断组合是否存在,不存在才继续
                        String key = nb + "-" + nh;
                        if (seen.contains(key)) {
                            continue;
                        }
                        seen.add(key);
                        //清除连续3个及以上相同颜色的球
                        nb = this.clear(nb);
                        if ("".equals(nb)) {
                            //桌上的球为空,结束
                            return cnt;
                        }
                        queue.add(new String[]{nb, nh});
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 循环清除,直到没有变化
     *
     * @param board 桌上的球
     * @return
     */
    private String clear(String board) {
        String temp;
        do {
            temp = board;
            int cnt = 1;
            char c = board.charAt(0);
            for (int i = 1; i < board.length(); i++) {
                if (board.charAt(i) == c) {
                    cnt++;
                } else {
                    if (cnt >= 3) {
                        board = board.substring(0, i - cnt) + board.substring(i);
                        cnt = 0;
                        break;
                    }
                    c = board.charAt(i);
                    cnt = 1;
                }
            }
            //清除尾部
            if (cnt >= 3) {
                board = board.substring(0, board.length() - cnt);
            }
        } while (board.length() >= 3 && board.length() != temp.length());
        return board;
    }

    class Solution1 {
        int INF = 0x3f3f3f3f;
        String b;
        int m;
        Map<String, Integer> map = new HashMap<>();

        public int findMinStep(String a, String _b) {
            b = _b;
            m = b.length();
            int ans = dfs(a, 1 << m);
            return ans == INF ? -1 : ans;
        }

        int dfs(String a, int cur) {
            if (a.length() == 0) {
                return 0;
            }
            if (map.containsKey(a)) {
                return map.get(a);
            }
            int ans = INF;
            int n = a.length();
            for (int i = 0; i < m; i++) {
                if (((cur >> i) & 1) == 1) {
                    continue;
                }
                int next = (1 << i) | cur;
                for (int j = 0; j <= n; j++) {
                    if (j > 0 && j < n - 1 && a.charAt(j) == a.charAt(j - 1)) {
                        continue;
                    }
                    if (j > 0 && j < n - 1 && a.charAt(j) != b.charAt(i)) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(a, 0, j).append(b.charAt(i)).append(a.substring(j));
                    int k = j;
                    while (0 <= k && k < sb.length()) {
                        char c = sb.charAt(k);
                        int l = k, r = k;
                        while (l >= 0 && sb.charAt(l) == c) {
                            l--;
                        }
                        while (r < sb.length() && sb.charAt(r) == c) {
                            r++;
                        }
                        if (r - l - 1 >= 3) {
                            sb.delete(l + 1, r);
                            k = l >= 0 ? l : r;
                        } else {
                            break;
                        }
                    }
                    ans = Math.min(ans, dfs(sb.toString(), next) + 1);
                }
            }
            map.put(a, ans);
            return ans;
        }
    }

    class Solution {
        class Node {
            String a;
            int cur, val, step;

            Node(String _a, int _c, int _v, int _s) {
                a = _a;
                cur = _c;
                val = _v;
                step = _s;
            }
        }

        int f(String a, int k) {
            Map<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                m1.put(a.charAt(i), m1.getOrDefault(a.charAt(i), 0) + 1);
            }
            for (int i = 0; i < m; i++) {
                if (((k >> i) & 1) == 0) {
                    m2.put(b.charAt(i), m2.getOrDefault(b.charAt(i), 0) + 1);
                }
            }
            int ans = 0;
            for (char c : m1.keySet()) {
                int c1 = m1.get(c), c2 = m2.getOrDefault(c, 0);
                if (c1 + c2 < 3) {
                    return INF;
                }
                if (c1 < 3) {
                    ans += (3 - c1);
                }
            }
            return ans;
        }

        int INF = 0x3f3f3f3f;
        String b;
        int m;
        Map<String, Integer> map = new HashMap<>();

        public int findMinStep(String _a, String _b) {
            b = _b;
            m = b.length();
            PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> (o.val + o.step)));
            q.add(new Node(_a, 1 << m, f(_a, 1 << m), 0));
            map.put(_a, 0);
            while (!q.isEmpty()) {
                Node poll = q.poll();
                String a = poll.a;
                int cur = poll.cur;
                int step = poll.step;
                int n = a.length();
                for (int i = 0; i < m; i++) {
                    if (((cur >> i) & 1) == 1) {
                        continue;
                    }
                    int next = (1 << i) | cur;
                    for (int j = 0; j <= n; j++) {
                        if (j > 0 && j < n - 1 && a.charAt(j) == a.charAt(j - 1)) {
                            continue;
                        }
                        if (j > 0 && j < n - 1 && a.charAt(j) != b.charAt(i)) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.substring(0, j)).append(b.substring(i, i + 1));
                        if (j != n) {
                            sb.append(a.substring(j));
                        }
                        int k = j;
                        while (0 <= k && k < sb.length()) {
                            char c = sb.charAt(k);
                            int l = k, r = k;
                            while (l >= 0 && sb.charAt(l) == c) {
                                l--;
                            }
                            while (r < sb.length() && sb.charAt(r) == c) {
                                r++;
                            }
                            if (r - l - 1 >= 3) {
                                sb.delete(l + 1, r);
                                k = l >= 0 ? l : r;
                            } else {
                                break;
                            }
                        }
                        String nextStr = sb.toString();
                        if (nextStr.length() == 0) {
                            return step + 1;
                        }
                        if (f(nextStr, next) == INF) {
                            continue;
                        }
                        if (!map.containsKey(nextStr) || map.get(nextStr) > step + 1) {
                            map.put(nextStr, step + 1);
                            q.add(new Node(nextStr, next, f(nextStr, next), step + 1));
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("1".substring(2));
    }
}
