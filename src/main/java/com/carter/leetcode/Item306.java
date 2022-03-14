package com.carter.leetcode;

public class Item306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int idx2 = 1; idx2 < num.length() - 1; idx2++) {
            if (idx2 > 1 && num.charAt(0) == '0') {
                break;
            }
            for (int idx3 = idx2 + 1; idx3 < num.length(); idx3++) {
                if (idx3 - idx2 > 1 && num.charAt(idx2) == '0') {
                    break;
                }
                if (dfs(num, 0, idx2, idx3)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯
     *
     * @param num
     * @param idxStart1 第一个数字开始下标,包含
     * @param idxStart2 第一个数字结束下标,不包含;第二个数字开始下标,包含
     * @param idxStart3 第二个数字结束下标,不包含
     * @return
     */
    private boolean dfs(String num, int idxStart1, int idxStart2, int idxStart3) {
        //第三个数字已经到末尾时,且第一个数字的开始下标不是0时,满足要求
        if (idxStart3 == num.length()) {
            return idxStart1 != 0;
        }
        //第三个数字超出字符串范围
        if (idxStart3 > num.length()) {
            return false;
        }
        //第三个数字的长度为max(第一个数字长度,第二个数字长度)
        int len3 = Math.max(idxStart2 - idxStart1, idxStart3 - idxStart2);
        //第三个数字的结束下标,不包含
        int idxEnd3 = idxStart3 + len3;
        //第一个数字和第二个数字,这里要用long
        long num1 = Long.parseLong(num.substring(idxStart1, idxStart2));
        long num2 = Long.parseLong(num.substring(idxStart2, idxStart3));
        //递归
        return (num.length() >= idxEnd3 && (len3 == 1 || num.charAt(idxStart3) != '0') && Long.parseLong(num.substring(idxStart3, idxEnd3)) == num1 + num2 && dfs(num, idxStart2, idxStart3, idxEnd3))
                || (num.length() >= idxEnd3 + 1 && num.charAt(idxStart3) != '0' && Long.parseLong(num.substring(idxStart3, idxEnd3 + 1)) == num1 + num2 && dfs(num, idxStart2, idxStart3, idxEnd3 + 1));
    }
}
