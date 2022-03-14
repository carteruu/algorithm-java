package com.carter.leetcode;

public class Item1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ss = new StringBuilder(a + b + c);
        dfs(a, 'a', b, 'b', c, 'c', ss);
        return ss.toString();
    }

    /**
     * 递归
     *
     * @param big     数量最多的字符数
     * @param bigChar 数量最多的字符
     * @param l1      非数量最多的字符数1
     * @param l1Char  非数量最多的字符1
     * @param l2      非数量最多的字符数2
     * @param l2Char  非数量最多的字符2
     * @param ss      答案
     */
    private void dfs(int big, char bigChar, int l1, char l1Char, int l2, char l2Char, StringBuilder ss) {
        if (big == 0 && l1 == 0 && l2 == 0) {
            //没有字符了,结束
            return;
        }
        //重新选出数量最多的字符
        if (l1 >= big && l1 > l2) {
            int temp = big;
            big = l1;
            l1 = temp;
            char tempChar = bigChar;
            bigChar = l1Char;
            l1Char = tempChar;
        } else if (l2 >= big && l2 >= l1) {
            int temp = big;
            big = l2;
            l2 = temp;
            char tempChar = bigChar;
            bigChar = l2Char;
            l2Char = tempChar;
        }
        //如果最后两个字符不是全是big字符,则将big字符追加到尾部;否则将l1或l2字符追加到尾部,如果此时l1和l2都为0,则结束
        if (ss.length() < 2 || ss.charAt(ss.length() - 1) != bigChar || ss.charAt(ss.length() - 2) != bigChar) {
            if (big == 1) {
                ss.append(bigChar);
                big = 0;
            } else {
                ss.append(bigChar);
                ss.append(bigChar);
                big -= 2;
            }
        } else if (l1 > 0) {
            ss.append(l1Char);
            l1--;
        } else if (l2 > 0) {
            ss.append(l2Char);
            l2--;
        } else {
            //不能继续追加了,结束
            return;
        }
        dfs(big, bigChar, l1, l1Char, l2, l2Char, ss);
    }
}
