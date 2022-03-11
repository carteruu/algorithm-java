package com.carter.leet;

public class Item153 {
    public int findMin(int[] nums) {
        int rs = nums[0];
        int low = 1;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[low] <= nums[mid]) {
                rs = Math.min(rs, nums[low]);

                low = mid + 1;
            } else {
                rs = Math.min(rs, nums[mid]);

                high = mid - 1;
            }
        }
        return rs;
    }
}
