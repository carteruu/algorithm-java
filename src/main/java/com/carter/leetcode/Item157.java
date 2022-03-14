package com.carter.leetcode;

/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */

public abstract class Item157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    private final char[] buf4 = new char[4];
    private int pos = buf4.length;

    public int read(char[] buf, int n) {
        int temp = buf4.length - pos;
        System.arraycopy(buf4, pos, buf, 0, Math.min(temp, n));
        if (temp > n) {
            pos += n;
            return n;
        } else {
            pos = buf4.length;
        }

        for (int i = temp; i < n; i += buf4.length) {
            int len = this.read4(buf4);
            System.arraycopy(buf4, 0, buf, i, Math.min(len, n - i));
            if (n - i <= len) {
                return n;
            }
            if (len < buf4.length) {
                return i + len;
            }
        }
        return n;
    }
}

abstract class Reader4 {
    abstract int read4(char[] buf4);
}