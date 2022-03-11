package com.carter.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 测试位图索引统计效率
 */
public class BitMap {
    @Test
    void test1() {
        Random random = new Random();
        long[][] state = new long[16][(int) 1e7 / 64 + 1];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                state[i][j] = random.nextLong();
            }
        }
        long start = System.currentTimeMillis();
        int cnt = 0;
        for (int i = 0; i < state[0].length; i++) {
            cnt += Long.bitCount(state[1][i] & state[8][i]);
        }
        System.out.printf("2个状态,人数：%s，耗时：%s ms%n", cnt, System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        cnt = 0;
        for (int i = 0; i < state[0].length; i++) {
            cnt += Long.bitCount(state[2][i] & state[8][i] & state[12][i] & state[15][i]);
        }
        System.out.printf("4个状态,人数：%s，耗时：%s ms%n", cnt, System.currentTimeMillis() - start);

        //查询id
        start = System.currentTimeMillis();
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < state[0].length; i++) {
            long ss = state[2][i] & state[8][i] & state[12][i] & state[15][i];
            long mark = 1;
            for (int j = 0; j < 64; j++) {
                if ((ss & mark) > 0) {
                    ids.add(random.nextLong());
                }
            }
        }
        System.out.printf("4个状态,id数：%s，耗时：%s ms%n", ids.size(), System.currentTimeMillis() - start);

        //分页查询，应该直接把状态转成bit，存在数据库。其他条件使用索引查询后，再用状态扫描查询出来的结果集（数据库可以直接支持），效率提升效果一般般
    }
}
