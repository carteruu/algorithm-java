package com.carter.leet;
import com.carter.TreeNode;
public class Item108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }

    private TreeNode bst(int[] nums, int left, int right) {
        if (left > right || left < 0 || right >= nums.length) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (right + left) / 2;
        return new TreeNode(nums[mid], bst(nums, left, mid - 1), bst(nums, mid + 1, right));
    }

}
