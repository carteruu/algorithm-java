package com.carter.leet;

import java.util.ArrayList;
import java.util.List;

public class Item2080 {
    public static class RangeFreqQuery {
        private List<Integer>[] posList;
        private int[] arr;

        public RangeFreqQuery(int[] arr) {
            this.arr = arr;
            posList = new List[10001];
            for (int i = 0; i < posList.length; i++) {
                posList[i] = new ArrayList<>();
            }
            for (int i = 0; i < arr.length; i++) {
                posList[arr[i]].add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> pos = this.posList[value];
            if (pos.size() == 0) {
                return 0;
            }
            int l = binarySearchGoe(pos, left);
            int r = binarySearchGt(pos, right);
            return r - l;
        }

        private int binarySearchGt(List<Integer> pos, int target) {
            int l = 0, r = pos.size() - 1;
            int gt = pos.size();
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (pos.get(mid) <= target) {
                    l = mid + 1;
                } else if (pos.get(mid) > target) {
                    gt = mid;
                    r = mid - 1;
                }
            }
            return gt;
        }

        private int binarySearchGoe(List<Integer> pos, int target) {
            int l = 0, r = pos.size() - 1;
            int goe = pos.size();
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (pos.get(mid) < target) {
                    l = mid + 1;
                } else if (pos.get(mid) >= target) {
                    goe = mid;
                    r = mid - 1;
                }
            }
            return goe;
        }
    }

    public static class RangeFreqQuery1 {
        private final int[] arr;
        private final int[][] maps;
        private final int interval = 128;
        private final int numCnt = 10001;

        public RangeFreqQuery1(int[] arr) {
            this.arr = arr;
            //计算各个值出现次数的前缀和
            this.maps = new int[arr.length / interval + 1][];
            this.maps[0] = new int[numCnt];
            for (int i = 1; i <= arr.length / interval; i++) {
                this.maps[i] = new int[numCnt];
                System.arraycopy(this.maps[i - 1], 0, this.maps[i], 0, numCnt);
                for (int j = (i - 1) * interval; j < i * interval; j++) {
                    this.maps[i][arr[j]] += 1;
                }
            }
        }

        public int query(int left, int right, int value) {
            //使用前缀和计算出现次数
            int cnt = this.maps[right / interval][value] - this.maps[left / interval][value];
            //减掉左边多算的次数
            for (int i = left / interval * interval; i < left; i++) {
                if (this.arr[i] == value) {
                    cnt--;
                }
            }
            //加上右边少算的次数
            for (int i = right / interval * interval; i <= right; i++) {
                if (this.arr[i] == value) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
