package com.carter.leet;

public class Item2166 {
    public static class Bitset {
        private final long[] bits;
        private final int size;
        private final int bitNum = 64;
        private int cntOne = 0;
        private long flip = 0;

        public Bitset(int size) {
            this.size = size;
            bits = new long[size / bitNum + 1];
        }

        public void fix(int idx) {
            if (isZero(idx)) {
                bits[idx / bitNum] ^= 1L << (idx % bitNum);
                cntOne++;
            }
        }

        public void unfix(int idx) {
            if (!isZero(idx)) {
                bits[idx / bitNum] ^= 1L << (idx % bitNum);
                cntOne--;
            }
        }

        public void flip() {
            flip ^= 1;
            cntOne = size - cntOne;
        }

        public boolean all() {
            return cntOne == size;
        }

        public boolean one() {
            return cntOne > 0;
        }

        public int count() {
            return cntOne;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(isZero(i) ? '0' : '1');
            }
            return sb.toString();
        }

        /**
         * @param idx
         * @return
         */
        private boolean isZero(int idx) {
            return (bits[idx / bitNum] & (1L << (idx % bitNum)) ^ (flip << (idx % bitNum))) == 0;
        }
    }

    public static class Bitset2 {
        private final long[] groups;
        private final int size;
        //0xffffffffffffffffL
        private final long mark = ~0L;
        private final int bitNum = 64;

        public Bitset2(int size) {
            //分段存,需要long的个数,不管是否整除,直接+1
            groups = new long[size / bitNum + 1];
            this.size = size;
        }

        /**
         * 某位设为1
         *
         * @param idx
         */
        public void fix(int idx) {
            groups[idx / bitNum] |= 1L << (idx % bitNum);
        }

        /**
         * 某位设为0
         *
         * @param idx
         */
        public void unfix(int idx) {
            groups[idx / bitNum] &= ~(1L << (idx % bitNum));
        }

        /**
         * 翻转
         */
        public void flip() {
            for (int i = 0; i < groups.length; i++) {
                groups[i] ^= mark;
            }
        }

        /**
         * 是否全部为1
         *
         * @return
         */
        public boolean all() {
            for (int i = 0; i < groups.length - 1; i++) {
                if (groups[i] != mark) {
                    return false;
                }
            }
            //特殊处理最后一个long
            long lastGroup = groups[groups.length - 1];
            for (int i = 0; i < size % bitNum; i++) {
                if ((lastGroup & (1L << i)) == 0) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 是否至少有一个1
         *
         * @return
         */
        public boolean one() {
            for (int i = 0; i < groups.length - 1; i++) {
                if (groups[i] != 0) {
                    return true;
                }
            }
            long lastGroup = groups[groups.length - 1];
            for (int i = 0; i < size % bitNum; i++) {
                if ((lastGroup & (1L << i)) > 0) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 1的个数
         *
         * @return
         */
        public int count() {
            int cnt = 0;
            for (int i = 0; i < groups.length - 1; i++) {
                cnt += Long.bitCount(groups[i]);
            }
            long lastGroup = groups[groups.length - 1];
            for (int i = 0; i < size % bitNum; i++) {
                if ((lastGroup & (1L << i)) > 0) {
                    cnt++;
                }
            }
            return cnt;
        }

        /**
         * @return
         */
        @Override
        public String toString() {
            StringBuilder rt = new StringBuilder();
            for (int i = 0; i < size; i++) {
                rt.append((groups[i / bitNum] & (1L << (i % bitNum))) == 0 ? '0' : '1');
            }
            return rt.substring(0, size);
        }
    }
}