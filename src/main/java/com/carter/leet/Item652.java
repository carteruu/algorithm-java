package com.carter.leet;

import com.carter.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Item652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }
        Map<String, Boolean> map = new HashMap<>();
        a(root, rs, map);
        return rs;
    }

    private String a(TreeNode node, List<TreeNode> rs, Map<String, Boolean> map) {
        if (node == null) {
            return "NULL-";
        }
        String str = node.val + "-";
        str += a(node.left, rs, map);
        str += a(node.right, rs, map);
        if (map.get(str) != null) {
            if (map.get(str)) {
                rs.add(node);
                map.put(str, Boolean.FALSE);
            }
        } else {
            map.put(str, Boolean.TRUE);
        }
        return str;
    }
}
