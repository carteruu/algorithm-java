package com.carter.leet;

public class Item2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int r = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (r < plants[i]) {
                ans += i * 2;
                r = capacity;
            }
            r -= plants[i];
            ans++;
        }
        return ans;
    }
}
