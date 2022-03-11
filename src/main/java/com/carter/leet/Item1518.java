package com.carter.leet;

public class Item1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        //这一轮的空瓶子数
        int emptyBottle = 0;
        while (numBottles > 0) {
            //喝掉
            ans += numBottles;
            //空瓶子
            int allEmptyBottle = numBottles + emptyBottle;
            //兑换到的酒
            numBottles = allEmptyBottle / numExchange;
            //兑换后,剩下的空瓶子
            emptyBottle = allEmptyBottle % numExchange;
        }
        return ans;
    }
}
