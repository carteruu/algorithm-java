package com.carter.leet;

import java.util.Arrays;
import java.util.TreeSet;

public class Item475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            //因为房屋和供暖器有序,如果当前房屋与当前供暖器的距离>=与下一个供暖器的距离,则跳到下一个供暖器
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }

    public int findRadius3(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(houses, heaters, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean check(int[] houses, int[] heaters, int x) {
        int n = houses.length, m = heaters.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && houses[i] > heaters[j] + x) {
                j++;
            }
            if (j < m && heaters[j] - x <= houses[i] && houses[i] <= heaters[j] + x) {
                continue;
            }
            return false;
        }
        return true;
    }


    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0, l1 = 0;
        for (int house : houses) {
            int floor = floor(heaters, l1, heaters.length - 1, house);
            int ceiling = floor + 1;
            int r = Integer.MAX_VALUE;
            if (floor != -1) {
                r = Math.min(r, house - heaters[floor]);
                l1 = floor;
            }
            if (ceiling < heaters.length) {
                r = Math.min(r, heaters[ceiling] - house);
            }
            ans = Math.max(ans, r);
        }
        return ans;
    }

    /**
     * 小于或等于
     *
     * @param heaters
     * @param start
     * @param end
     * @param find
     * @return
     */
    private int floor(int[] heaters, int start, int end, int find) {
        int rt = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (heaters[mid] == find) {
                return mid;
            } else if (heaters[mid] < find) {
                rt = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return rt;
    }

    /**
     * 大于或等于
     *
     * @param heaters
     * @param find
     * @return 下标
     */
    private int ceiling(int[] heaters, int start, int end, int find) {
        int rt = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (heaters[mid] == find) {
                return mid;
            } else if (heaters[mid] < find) {
                start = mid + 1;
            } else {
                rt = mid;
                end = mid - 1;
            }
        }
        return rt;
    }

    public int findRadius1(int[] houses, int[] heaters) {
        TreeSet<Integer> h = new TreeSet<>();
        for (int heater : heaters) {
            h.add(heater);
        }
        int ans = 0;
        for (int house : houses) {
            Integer ceiling = h.ceiling(house);
            Integer floor = h.floor(house);
            int r = Integer.MAX_VALUE;
            if (ceiling != null) {
                r = Math.min(r, ceiling - house);
            }
            if (floor != null) {
                r = Math.min(r, house - floor);
            }
            ans = Math.max(ans, r);
        }
        return ans;
    }
}
