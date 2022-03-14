package com.carter.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Item1610 {
    public int visiblePoints2(List<List<Integer>> points, int angle, List<Integer> location) {
        int seen = 0;
        List<Double> pointsTheta = new ArrayList<>(points.size());
        int locationY = location.get(1);
        int locationX = location.get(0);
        for (List<Integer> point : points) {
            if (Objects.equals(point.get(0), locationX) && Objects.equals(point.get(1), locationY)) {
                seen++;
                continue;
            }
            double theta = Math.atan2(point.get(1) - locationY, point.get(0) - locationX);
            pointsTheta.add(theta);
        }
        Collections.sort(pointsTheta);
        int m = pointsTheta.size();
        for (int i = 0; i < m; i++) {
            pointsTheta.add(pointsTheta.get(i) + 2 * Math.PI);
        }
        int ans = 0;
        int r = 0;
        double theta = angle * Math.PI / 180;
        for (int l = 0; l < pointsTheta.size(); l++) {
            double endTheta = theta + pointsTheta.get(l);
            while (r < pointsTheta.size() && pointsTheta.get(r) <= endTheta) {
                r++;
            }
            ans = Math.max(ans, r - l);
        }
        return seen + ans;
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int seen = 0;
        List<Double> pointsAngle = new ArrayList<>(points.size());
        int locationY = location.get(1);
        int locationX = location.get(0);
        for (List<Integer> point : points) {
            if (Objects.equals(point.get(0), locationX) && Objects.equals(point.get(1), locationY)) {
                seen++;
                continue;
            }
            pointsAngle.add(Math.atan2(point.get(1) - locationY, point.get(0) - locationX) / Math.PI * 180);
        }
        Collections.sort(pointsAngle);
        int m = pointsAngle.size();
        for (int i = 0; i < m; i++) {
            pointsAngle.add(pointsAngle.get(i) + 360);
        }
        int ans = 0;
        int r = 0;
        for (int l = 0; l < pointsAngle.size(); l++) {
            double endAngle = angle + pointsAngle.get(l);
            while (r < pointsAngle.size() && pointsAngle.get(r) <= endAngle) {
                r++;
            }
            ans = Math.max(ans, r - l);
        }
        return seen + ans;
    }

    static class Solution {
        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int sameCnt = 0;
            List<Double> polarDegrees = new ArrayList<>();
            int locationX = location.get(0);
            int locationY = location.get(1);
            for (int i = 0; i < points.size(); ++i) {
                int x = points.get(i).get(0);
                int y = points.get(i).get(1);
                if (x == locationX && y == locationY) {
                    sameCnt++;
                    continue;
                }
                Double degree = Math.atan2(y - locationY, x - locationX);
                polarDegrees.add(degree);
            }
            Collections.sort(polarDegrees);

            int m = polarDegrees.size();
            for (int i = 0; i < m; ++i) {
                polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
            }

            int maxCnt = 0;
            Double toDegree = angle * Math.PI / 180;
            for (int i = 0; i < m; ++i) {
                int iteration = binarySearch(polarDegrees, polarDegrees.get(i) + toDegree, false);
                maxCnt = Math.max(maxCnt, iteration - i);
            }
            return maxCnt + sameCnt;
        }

        public int binarySearch(List<Double> nums, Double target, boolean lower) {
            int left = 0, right = nums.size() - 1;
            int ans = nums.size();
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums.get(mid) > target || (lower && nums.get(mid) >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

}
