package com.carter.leetcode;

import com.carter.TreeNode;

import java.util.HashMap;
import java.util.Map;
/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Item106 {
    int rootId;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        rootId = postorder.length - 1;
        return h(postorder, map, 0, inorder.length - 1);
    }

    private TreeNode h(int[] postorder, Map<Integer, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[rootId]);
        Integer idx = map.get(postorder[rootId]);
        rootId--;
        //这里要先生成右子树,再生成左子树.
        // 因为后序遍历是先左子树再右子树,
        // 所以后序遍历结果倒序是:根节点,右子树根节点,右右子树根节点
        node.right = h(postorder, map, idx + 1, end);
        node.left = h(postorder, map, start, idx - 1);
        return node;
    }
}
