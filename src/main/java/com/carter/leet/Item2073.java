package com.carter.leet;

public class Item2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[k], tickets[i]);
            } else {
                ans += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return ans;
    }

    public int timeRequiredToBuy1(int[] tickets, int k) {
        //前面的人及自己,买一张票的时间
        int ans = k + 1;
        if (tickets[k] == 1) {
            return ans;
        }
        for (int i = 0; i <= k; i++) {
            tickets[i]--;
        }
        //第k个人来到队尾
        //第k个人每买一张票,所有人都可以买一张票.如果需要买票,就加一秒[doge]
        while (tickets[k] > 0) {
            for (int j = 0; j < tickets.length; j++) {
                if (tickets[j] > 0) {
                    tickets[j]--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
