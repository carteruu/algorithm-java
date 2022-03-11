package com.carter;

public class BinarySearch {
    /**
     * 相等的下标
     *
     * @param arr
     * @param target
     * @return
     */
    public int find(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * @param arr
     * @param target
     * @param lower  为true:第一个等于target;为false:最后一个等于target
     * @return
     */
    public int findBound(int[] arr, int target, boolean lower) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] == target) {
                ans = mid;
            }
            if (arr[mid] > target || (lower && arr[mid] == target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * @param nums
     * @param target
     * @param lower  为true:第一个大于等于target;为false:第一个大于target
     * @return
     */
    public int findBound1(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 相等的下标-最左
     *
     * @param arr
     * @param target
     * @return
     */
    public int findLeft(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] >= target) {
                right = mid - 1;
                if (arr[mid] == target) {
                    ans = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 相等的下标-最右
     *
     * @param arr
     * @param target
     * @return
     */
    public int findRight(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                if (arr[mid] == target) {
                    ans = mid;
                }
            }
        }
        return ans;
    }

    public int findLeft1(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] == target ? left : -1;
    }

    public int findRight1(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left + 1) >> 1) + left;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return arr[left] == target ? left : -1;
    }

    /**
     * 最小的大于
     *
     * @param arr
     * @param target
     * @return
     */
    public int minBig(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    /**
     * 最小的大于
     *
     * @param arr
     * @param target
     * @return
     */
    public int minBig1(int[] arr, int target) {
        if (arr[arr.length - 1] <= target) {
            return arr.length;
        }
        if (arr[0] > target) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * TODO 最大的小于
     *
     * @param arr
     * @param target
     * @return
     */
    public int maxLittle(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r;
    }

    /**
     * 最大的小于
     *
     * @param arr
     * @param target
     * @return
     */
    public int maxLittle1(int[] arr, int target) {
        if (arr[0] > target) {
            return -1;
        }
        if (arr[arr.length - 1] < target) {
            return arr.length - 1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    //TODO 第一个大于等于
    //TODO 第一个大于
}
