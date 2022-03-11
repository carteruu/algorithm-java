package com.carter.leet;

import java.util.ArrayList;
import java.util.List;

public class Item17 {
    private final char[][] arr = new char[][]{
            null,
            null,
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    private List<String> ans;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        ans = new ArrayList<>(4 ^ digits.length());
        dfs(digits.toCharArray(), 0, new char[digits.length()]);
        return ans;
    }

    private void dfs(char[] digits, int idx, char[] sb) {
        if (idx == digits.length) {
            ans.add(new String(sb));
            return;
        }
        char[] letters = arr[digits[idx] - '0'];
        for (char letter : letters) {
            sb[idx] = letter;
            dfs(digits, idx + 1, sb);
        }
    }
}
