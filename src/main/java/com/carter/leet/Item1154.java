package com.carter.leet;

public class Item1154 {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int leap = 0;
        if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
            leap = 1;
        }
        int[] monthDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = day;
        for (int i = 0; i < month - 1; i++) {
            ans += monthDay[i];
        }
        return month > 2 ? ans + leap : ans;
    }
}
