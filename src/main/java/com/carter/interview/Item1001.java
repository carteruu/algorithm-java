package com.carter.interview;

public class Item1001 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int pa = 0, pb = 0;
            int[] sorted = new int[m + n];
            int cur;
            while (pa < m || pb < n) {
                if (pa == m) {
                    cur = B[pb++];
                } else if (pb == n) {
                    cur = A[pa++];
                } else if (A[pa] < B[pb]) {
                    cur = A[pa++];
                } else {
                    cur = B[pb++];
                }
                sorted[pa + pb - 1] = cur;
            }
            for (int i = 0; i != m + n; ++i) {
                A[i] = sorted[i];
            }
        }
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1;
        int pb = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (pb == -1) {
                A[i] = A[pa--];
            } else if (pa == -1) {
                A[i] = B[pb--];
            } else if (A[pa] > B[pb]) {
                A[i] = A[pa--];
            } else {
                A[i] = B[pb--];
            }
        }
    }

    public void merge1(int[] A, int m, int[] B, int n) {
        int[] A1 = new int[m];
        System.arraycopy(A, 0, A1, 0, m);
        int idx = 0;
        int a = 0;
        int b = 0;
        while (a < m || b < n) {
            if (b >= n || (a < m && A1[a] <= B[b])) {
                A[idx] = A1[a];
                a++;
            } else {
                A[idx] = B[b];
                b++;
            }
            idx++;
        }
    }
}
