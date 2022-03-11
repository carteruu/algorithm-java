package com.carter.js;

import java.util.Arrays;

public class Item2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] preSumLeft = new long[n + 1];
        long[] preSumRight = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumLeft[i + 1] = preSumLeft[i] + beans[i];
            preSumRight[n - 1 - i] = preSumRight[n - i] + beans[n - 1 - i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, preSumLeft[i] + preSumRight[i + 1] - (long) beans[i] * (n - 1 - i));
        }
        return ans;
    }

    public long minimumRemoval2(int[] beans) {
        long max = 0;
        for (int num : beans) {
            max = Math.max(max, num);
        }
        long min = 0;
        long diff = 0;
        while (min <= max) {
            long mid = (max - min) / 2 + min;
            if (check(mid)) {
                diff = mid;
                min = mid;
            } else {
                max = mid;
            }
        }
        long ans = 0;
        for (int num : beans) {
            if (num > diff) {
                ans += num - diff;
            } else if (num < diff) {
                ans += num;
            }
        }
        return ans;
    }

    private boolean check(long num) {
        return false;
    }

    public long minimumRemoval1(int[] beans) {
        long sum = 0;
        long cnt = 0;
        int max = 0;
        for (int num : beans) {
            sum += num;
            if (num > 0) {
                cnt++;
            }
            max = Math.max(max, num);
        }
        long abv = sum / cnt;

        int ans = 0;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < beans.length; i++) {
                if (beans[i] == 0) {
                    continue;
                }
                if (beans[i] < abv) {
                    ans += beans[i];
                    cnt--;
                    sum -= beans[i];
                    beans[i] = 0;
                    change = true;
                } else if (beans[i] > abv) {
                    ans += beans[i] - abv;
                    sum -= beans[i] - abv;
                    beans[i] = (int) abv;
                    change = true;
                }
            }
            abv = sum / cnt;
        }
        return ans;
    }
}
