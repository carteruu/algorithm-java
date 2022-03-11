package com.carter.leet;

import java.util.Arrays;

public class Item2141 {
    public long maxRunTime(int n, int[] batteries) {
        long min = Integer.MAX_VALUE;
        long sum = 0;
        for (int b : batteries) {
            min = Math.min(min, b);
            sum += b;
        }
        long ans = 0;
        while (min <= sum) {
            long mid = (min + sum) >> 1;
            if (check(n, batteries, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                sum = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int n, int[] batteries, long time) {
        long sum = 0;
        for (int b : batteries) {
            sum += Math.min(b, time);
        }
        return sum / time >= n;
    }

    public long maxRunTime3(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }
        for (int i = batteries.length - 1; i >= 0; i--) {
            if (batteries[i] > sum / n) {
                n--;
                sum -= batteries[i];
            } else {
                return sum / n;
            }
        }
        return 0;
    }

    public long maxRunTime2(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }
        for (int i = batteries.length - 1; i >= 0; i--) {
            int b = batteries[i];
            if (b > sum / n) {
                n--;
                sum -= b;
            } else {
                return sum / n;
            }
        }
        return 0;
    }

    public long maxRunTime1(int n, int[] batteries) {
        long left = 0, right = 100000000000000L;
        while (left < right) {
            long mid = (left + right + 1) / 2, sum = 0;
            for (int battery : batteries) {
                sum += Math.min(mid, battery);
            }
            if (sum / n < mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
