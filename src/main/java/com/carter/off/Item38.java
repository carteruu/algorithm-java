package com.carter.off;

import java.util.*;

public class Item38 {
    public String[] permutation(String s) {
        int len = s.length();
        if (len < 1) {
            return new String[0];
        }
        if (len == 1) {
            return new String[]{s};
        }
        List<String> strList = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        permutationCore(0, strList, chars, len);
        return strList.toArray(new String[0]);
    }

    private void permutationCore(int index, List<String> strList, char[] s, int len) {
        if (index == len - 1) {
            strList.add(new String(s));
            return;
        }
        for (int i = index; i < len; i++) {
            if (i != index && s[i] == s[index]) {
                continue;
            }
            swap(s, index, i);
            permutationCore(index + 1, strList, s, len);
        }

        char tmp = s[index];
        for (int i = index; i < len - 1; i++)
            s[i] = s[i + 1];
        s[len - 1] = tmp;
    }

    /**
     * 交换字符方法
     *
     * @param s
     * @return
     */
    public String[] permutation2(String s) {
        Set<String> rs = new HashSet<>(s.length() * (s.length() - 1));
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        permutation(chars, 0, rs);
        return rs.toArray(new String[0]);
    }

    private void permutation(char[] chars, int i, Set<String> rs) {
        if (i == chars.length) {
            rs.add(new String(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            if (j != i && chars[j] == chars[i]) {
                //相同字符串交换没有意义
                continue;
            }
            swap(chars, i, j);
            permutation(chars, i + 1, rs);
            swap(chars, j, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 拼接字符串方法
     *
     * @param s
     * @return
     */
    public String[] permutation1(String s) {
        Set<String> rs = new HashSet<>(s.length() * (s.length() - 1));
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }

        permutation(list, "", rs);
        return rs.toArray(new String[0]);
    }

    private void permutation(List<Character> chars, String prefix, Set<String> rs) {
        if (chars.isEmpty()) {
            rs.add(prefix);
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            Character remove = chars.remove(i);
            permutation(chars, prefix + remove, rs);
            chars.add(i, remove);
        }
    }
}
