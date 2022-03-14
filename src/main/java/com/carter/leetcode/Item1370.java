package com.carter.leetcode;

public class Item1370 {
    public String sortString(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            arr[c - 'a']++;
        }

        int idx = 0;
        char[] rs = new char[s.length()];
        while (idx < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    arr[i]--;
                    rs[idx++] = (char) (i + 'a');
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    arr[i]--;
                    rs[idx++] = (char) (i + 'a');
                }
            }
        }
        return new String(rs);
    }

    public String sortString1(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            arr[c - 'a']++;
        }

        int idx = 0;
        int step = 1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            if (arr[idx] > 0) {
                arr[idx]--;
                sb.append((char) (idx + 'a'));
            }
            idx += step;
            if (idx == arr.length || idx == -1) {
                step = -step;
                idx += step;
            }
        }
        return sb.toString();
    }
}
