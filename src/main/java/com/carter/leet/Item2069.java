package com.carter.leet;

public class Item2069 {
    public static class Robot {
        private final int width;
        private final int height;
        private final int c;
        private int num;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            c = 2 * (width + height) - 4;
        }

        public void move(int num) {
            this.num += num;
        }

        public int[] getPos() {
            int m = num % c;
            if (m < width) {
                //下边
                return new int[]{m, 0};
            } else if (m < width + height - 1) {
                //右边
                return new int[]{width - 1, m - width + 1};
            } else if (m < 2 * width + height - 2) {
                //上边
                return new int[]{2 * width + height - m - 3, height - 1};
            } else {
                //左边
                return new int[]{0, c - m};
            }
        }

        public String getDir() {
            int m = num % c;
            if (num == 0 || (m > 0 && m < width)) {
                return "East";
            } else if (m > 0 && m < width + height - 1) {
                return "North";
            } else if (m > 0 && m < 2 * width + height - 2) {
                return "West";
            } else {
                return "South";
            }
        }
    }
}

