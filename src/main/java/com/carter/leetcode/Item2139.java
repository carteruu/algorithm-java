package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item2139 {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                //没有加倍次数了,只能递增,直接计算次数
                return ans + target - 1;
            }
            if ((target & 1) == 1) {
                //当target为奇数时,先减1,次数+1
                ans++;
                target--;
            }
            //除以2,可加倍次数减一,加倍操作一次
            maxDoubles--;
            target >>= 1;
            ans++;
        }
        return ans;
    }

    public int minMoves2(int target, int maxDoubles) {
        if (target == 1) {
            //完成了
            return 0;
        }
        if (maxDoubles == 0) {
            //没有加倍次数了,只能递增
            return target - 1;
        }
        //当target为奇数时,先减1,递增操作一次
        int step = (target & 1) == 1 ? 1 : 0;
        //再除以2,可加倍次数减一,加倍操作一次
        maxDoubles--;
        return minMoves(target / 2, maxDoubles) + 1 + step;
    }

    public int minMoves1(int target, int maxDoubles) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, maxDoubles});
        int ans = 0;
        while (queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                int[] poll = queue.poll();
                if (poll[0] == target) {
                    return ans;
                }
                queue.offer(new int[]{poll[0] + 1, poll[1]});
                if (poll[1] > 0) {
                    poll[0] *= 2;
                    poll[1]--;
                    queue.offer(poll);
                }
            }
            ans++;
        }
        return -1;
    }
}
