package com.carter.leetcode;

import java.util.*;

public class Item127 {
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //中间单词,使用set提高效率
        Set<Long> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(this.getKey(word));
        }
        if (!wordSet.contains(this.getKey(endWord))) {
            //endWord不在中间单词中,直接返回0
            return 0;
        }

        Queue<Long> beginQueue = new ArrayDeque<>(wordList.size());
        long beginKey = this.getKey(beginWord);
        beginQueue.add(beginKey);
        Map<Long, Integer> beginTimes = new HashMap<>(wordList.size());
        beginTimes.put(beginKey, 1);

        Queue<Long> endQueue = new ArrayDeque<>(wordList.size());
        long endKey = this.getKey(endWord);
        endQueue.add(endKey);
        Map<Long, Integer> endTimes = new HashMap<>(wordList.size());
        endTimes.put(endKey, 0);
        //两个队列都不为空才需要继续
        while (beginQueue.size() > 0 && endQueue.size() > 0) {
            Integer ans;
            if (beginQueue.size() <= endQueue.size()) {
                ans = bfs2(wordSet, beginQueue, beginTimes, endTimes);
            } else {
                ans = bfs2(wordSet, endQueue, endTimes, beginTimes);
            }
            if (ans != null) {
                return ans;
            }
        }
        return 0;
    }

    private Integer bfs2(Set<Long> wordSet, Queue<Long> q1, Map<Long, Integer> map1, Map<Long, Integer> map2) {
        //每访问一层+1
        int size = q1.size();
        for (int i = 0; i < size; i++) {
            long poll = q1.poll();
            int times = map1.get(poll) + 1;
            //依次变换每一个字符
            for (long s = 1; poll / s > 0; s *= 26) {
                for (int newVal = 0; newVal < 26; newVal++) {
                    long oldVal = poll / s % 26 * s;
                    //减掉原来字符的值,加上新的值
                    Long next = poll - oldVal + (newVal * s);
                    if (!wordSet.contains(next) || map1.containsKey(next)) {
                        //不是中间单词,或已访问过
                        continue;
                    }
                    if (map2.containsKey(next)) {
                        //找到了
                        return times + map2.get(next);
                    }
                    //加入队列,继续
                    q1.offer(next);
                    map1.put(next, times);
                }
            }
        }
        return null;
    }

    protected long getKey(String str) {
        long key = 0;
        for (int i = 0; i < str.length(); i++) {
            key = key * 26 + str.charAt(i) - 'a';
        }
        return key;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //中间单词,使用set提高效率
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            //endWord不在中间单词中,直接返回0
            return 0;
        }

        Queue<String> beginQueue = new ArrayDeque<>(wordList.size());
        beginQueue.add(beginWord);
        Map<String, Integer> beginTimes = new HashMap<>(wordList.size());
        beginTimes.put(beginWord, 0);

        Queue<String> endQueue = new ArrayDeque<>(wordList.size());
        endQueue.add(endWord);
        Map<String, Integer> endTimes = new HashMap<>(wordList.size());
        endTimes.put(endWord, 0);
        //两个队列都不为空才需要继续
        while (beginQueue.size() > 0 && endQueue.size() > 0) {
            Integer ans;
            //那个队列短,用那个队列遍历
            if (beginQueue.size() <= endQueue.size()) {
                ans = bfs(wordSet, beginQueue, beginTimes, endTimes);
            } else {
                ans = bfs(wordSet, endQueue, endTimes, beginTimes);
            }
            if (ans != null) {
                return ans + 1;
            }
        }
        return 0;
    }

    /**
     * 双向BFS
     *
     * @param wordSet 中间单词
     * @param queue   队列
     * @param cur     当前队列生成的字符及其次数
     * @param other   另一个队列生成的字符及其次数
     * @return
     */
    private Integer bfs(Set<String> wordSet, Queue<String> queue, Map<String, Integer> cur, Map<String, Integer> other) {
        //每访问一层+1
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String poll = queue.poll();
            int times = cur.get(poll) + 1;
            //依次改变每一个字符
            for (int j = 0; j < poll.length(); j++) {
                //改变一个字符为a-z
                char[] nextChar = poll.toCharArray();
                for (int k = 0; k < 26; k++) {
                    nextChar[j] = (char) ('a' + k);
                    String next = new String(nextChar);
                    if (!wordSet.contains(next) || cur.containsKey(next)) {
                        //不是中间单词,或已访问过,跳过
                        continue;
                    }
                    if (other.containsKey(next)) {
                        //当前队列生成的字符串,存在另一个队列生成的字符串
                        return times + other.get(next);
                    }
                    //加入队列,继续
                    queue.offer(next);
                    cur.put(next, times);
                }
            }
        }
        return null;
    }

    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        //中间单词,使用set提高效率
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            //endWord不在中间单词中,直接返回0
            return 0;
        }
        //BFS
        Queue<String> queue = new ArrayDeque<>(wordList.size());
        queue.add(beginWord);
        int ans = 1;
        while (queue.size() > 0) {
            //每访问一层+1
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                //依次变换每一个字符
                for (int j = 0; j < poll.length(); j++) {
                    char[] nextChar = poll.toCharArray();
                    for (int k = 0; k < 26; k++) {
                        nextChar[j] = (char) ('a' + k);
                        String next = new String(nextChar);
                        if (!wordSet.contains(next)) {
                            //不是中间单词
                            continue;
                        }
                        if (next.equals(endWord)) {
                            //找到了
                            return ans;
                        }
                        //加入队列,继续
                        queue.offer(next);
                        //从中间单词集合移除,避免重复访问
                        wordSet.remove(next);
                    }
                }
            }
        }
        return 0;
    }

    public static class Solution {
        String s, e;
        Set<String> set = new HashSet<>();

        public int ladderLength(String _s, String _e, List<String> ws) {
            s = _s;
            e = _e;
            // 将所有 word 存入 set，如果目标单词不在 set 中，说明无解
            set.addAll(ws);
            if (!set.contains(e)) {
                return 0;
            }
            int ans = bfs();
            return ans == -1 ? 0 : ans + 1;
        }

        int bfs() {
            // d1 代表从起点 beginWord 开始搜索（正向）
            // d2 代表从结尾 endWord 开始搜索（反向）
            Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque();

            /*
             * m1 和 m2 分别记录两个方向出现的单词是经过多少次转换而来
             * e.g.
             * m1 = {"abc":1} 代表 abc 由 beginWord 替换 1 次字符而来
             * m1 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
             */
            Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
            d1.add(s);
            m1.put(s, 0);
            d2.add(e);
            m2.put(e, 0);

            /*
             * 只有两个队列都不空，才有必要继续往下搜索
             * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
             * e.g.
             * 例如，如果 d1 为空了，说明从 beginWord 搜索到底都搜索不到 endWord，反向搜索也没必要进行了
             */
            while (!d1.isEmpty() && !d2.isEmpty()) {
                int t;
                // 为了让两个方向的搜索尽可能平均，优先拓展队列内元素少的方向
                if (d1.size() <= d2.size()) {
                    t = update(d1, m1, m2);
                } else {
                    t = update(d2, m2, m1);
                }
                if (t != -1) {
                    return t;
                }
            }
            return -1;
        }

        // update 代表从 deque 中取出一个单词进行扩展，
        // cur 为当前方向的距离字典；other 为另外一个方向的距离字典
        int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
            // 获取当前需要扩展的原字符串
            String poll = deque.pollFirst();
            int n = poll.length();

            // 枚举替换原字符串的哪个字符 i
            for (int i = 0; i < n; i++) {
                // 枚举将 i 替换成哪个小写字母
                for (int j = 0; j < 26; j++) {
                    // 替换后的字符串
                    String sub = poll.substring(0, i) + (char) ('a' + j) + poll.substring(i + 1);
                    if (set.contains(sub)) {
                        // 如果该字符串在「当前方向」被记录过（拓展过），跳过即可
                        if (cur.containsKey(sub)) {
                            continue;
                        }

                        // 如果该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                        if (other.containsKey(sub)) {
                            return cur.get(poll) + 1 + other.get(sub);
                        } else {
                            // 否则加入 deque 队列
                            deque.addLast(sub);
                            cur.put(sub, cur.get(poll) + 1);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
