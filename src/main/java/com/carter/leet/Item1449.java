package com.carter.leet;

import java.util.*;
import java.util.stream.Collectors;

public class Item1449 {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c : cost) {
            for (int j = c; j <= target; ++j) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 8, j = target; i >= 0; i--) {
            for (int c = cost[i]; j >= c && dp[j] == dp[j - c] + 1; j -= c) {
                sb.append(i + 1);
            }
        }
        return sb.toString();
    }

    public String largestNumber1(int[] cost, int target) {
        //成本->数,相同成本,只保留大的数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            map.put(cost[i], i + 1);
        }
        List<Integer>[] arr = new List[target + 1];
        arr[0] = new ArrayList<>();
        Comparator<Integer> reversed = Comparator.comparingInt(Integer::intValue).reversed();
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <= i; j++) {
                Integer num = map.get(i - j);
                if (num != null && arr[j] != null) {
                    //可以组成当前的成本
                    if (arr[i] == null || arr[j].size() + 1 > arr[i].size()) {
                        arr[i] = new ArrayList<>(arr[j]);
                        arr[i].add(0, num);
                        arr[i].sort(reversed);
                        map.put(i, arr[i].stream().mapToInt(Integer::intValue).sum());
                    }
                    if (arr[j].size() + 1 == arr[i].size()) {
                        List newList = new ArrayList<>(arr[j]);
                        newList.add(num);
                        for (int k = 0; k < arr[i].size(); k++) {
                            if ((int) newList.get(k) > arr[i].get(k)) {
                                arr[i] = newList;
                                arr[i].sort(reversed);
                                map.put(i, arr[i].stream().mapToInt(Integer::intValue).sum());
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (arr[target] == null) {
            return "0";
        }
        return arr[target].stream().map(Objects::toString).collect(Collectors.joining(""));
    }
}
