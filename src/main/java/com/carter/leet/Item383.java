package com.carter.leet;

public class Item383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (cnt[idx] == 0) {
                return false;
            }
            cnt[idx]--;
        }
        return true;
    }
}
