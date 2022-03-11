package com.carter.leet;

public class Item2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        //最大值为数量最多的商品
        int max = quantities[0];
        //最小值1
        int min = 1;
        for (int i = 0; i < quantities.length; i++) {
            max = Math.max(max, quantities[i]);
        }
        if (n == quantities.length) {
            return max;
        }
        while (min < max) {
            int mid = (max + min) / 2;
            boolean check = this.check(n, quantities, mid);
            if (check) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    /**
     * 每个商店分配p个商品,能否满足题目要求
     *
     * @param n
     * @param quantities
     * @param p          数量
     * @return
     */
    private boolean check(int n, int[] quantities, int p) {
        int nn = 0;
        for (int q : quantities) {
            //计算每一种商品,需要分配到多少个商店
            nn += q / p;
            if (q % p > 0) {
                //每个商店只能分配一种商品,所以这里有余数时,直接+1
                nn++;
            }
        }
        return nn <= n;
    }
}
