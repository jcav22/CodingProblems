package com.jcav22.problems.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, String.valueOf(root.val)));

        while (!stack.empty()) {
            Pair pair = stack.pop();
            if (isLeaf(pair.node)) {
                result.add(pair.path);
            } else {
                TreeNode left = pair.node.left;
                TreeNode right = pair.node.right;
                if (left != null) {
                    stack.push(new Pair(pair.node.left, pair.path + "->" + left.val));
                }
                if (right != null) {
                    stack.push(new Pair(right, pair.path + "->" + right.val));
                }
            }
        }
        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static class Pair {
        TreeNode node;
        String path;

        Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    // Class provided for the problem
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
