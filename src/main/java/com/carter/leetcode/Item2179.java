package com.carter.leetcode;

import java.util.Arrays;

public class Item2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        long index[] = new long[nums1.length],
                count[] = new long[nums1.length],
                result = 0;
        for (int i = 0; i < nums1.length; i++) {
            index[nums2[i]] = i;
        }
        Bit bit1 = new Bit(nums1.length), bit2 = new Bit(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            count[i] = bit1.query((int) index[nums1[i]]);
            bit1.update((int) index[nums1[i]]);
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            result += (bit2.query(nums1.length - 1) - bit2.query((int) index[nums1[i]])) * count[i];
            bit2.update((int) index[nums1[i]]);
        }
        return result;
    }

    private static class Bit {
        private int[] bit;

        private Bit(int n) {
            bit = new int[n];
        }

        private int query(int i) {
            int result = 0;
            for (; i >= 0; i = (i & i + 1) - 1) {
                result += bit[i];
            }
            return result;
        }

        private void update(int i) {
            for (; i < bit.length; i |= i + 1) {
                bit[i]++;
            }
        }
    }

    public long goodTriplets2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] numPos2 = new int[n];
        for (int i = 0; i < n; i++) {
            numPos2[nums2[i]] = i;
        }
        long ans = 0;
        long[] cnt = new long[n];
        for (int i = 1; i < n - 1; i++) {
            long c = 0;
            for (int j = i + 1; j < n; j++) {
                if (numPos2[nums1[i]] < numPos2[nums1[j]]) {
                    c++;
                }
            }
            cnt[i] = c;
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (numPos2[nums1[i]] >= numPos2[nums1[j]]) {
                    continue;
                }
                ans += cnt[numPos2[nums2[j]]];
            }
        }
        return ans;
    }

    public long goodTriplets1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] numPos2 = new int[n];
        for (int i = 0; i < n; i++) {
            numPos2[nums2[i]] = i;
        }
        long ans = 0;
        long[] cnt = new long[n];
        Arrays.fill(cnt, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numPos2[nums1[i]] >= numPos2[nums1[j]]) {
                    continue;
                }
                if (cnt[j] != -1) {
                    ans += cnt[j];
                    continue;
                }
                long c = 0;
                for (int k = j + 1; k < n; k++) {
                    if (numPos2[nums1[j]] < numPos2[nums1[k]]) {
                        c++;
                    }
                }
                cnt[j] = c;
                ans += c;
            }
        }
        return ans;
    }
}
