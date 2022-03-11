package com.carter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    public static void main(String... args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(inputList);
        preOrderTraveralWithStack(treeNode);
        System.out.println();
        preOrderTraveral(treeNode);
        System.out.println();
        inOrderTraveralWithStack(treeNode);
        System.out.println();
        inOrderTraveral(treeNode);
        System.out.println();
        postOrderTraveralWithStack(treeNode);
        System.out.println();
        postOrderTraveral(treeNode);
        System.out.println();
        System.out.print("层序遍历：");
        levelOrderTraversal(treeNode);
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraveral(node.rightChild);
    }

    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                //前序遍历，先输出节点数据
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    public static void inOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.rightChild;
            }
        }
    }

    public static void postOrderTraveralWithStack(TreeNode root) {

    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }
}
