package com.carter.leet;

import java.util.ArrayList;
import java.util.List;

public class Item6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Character[][] arr = new Character[numRows][s.length()];
        int[][] steps = new int[][]{{1, 0}, {-1, 1}};
        int stepIdx = 0;
        int row = 0, col = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[row][col] = s.charAt(i);
            int nextRow = row + steps[stepIdx][0];
            if (nextRow >= numRows || nextRow < 0) {
                stepIdx = (stepIdx + 1) % 2;
            }
            row += steps[stepIdx][0];
            col += +steps[stepIdx][1];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != null) {
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
