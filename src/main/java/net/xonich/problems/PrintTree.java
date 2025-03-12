package net.xonich.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintTree {

    public static class TreeNode {

        String val;
        TreeNode r;
        TreeNode l;
    }

    public static void printTreeRecursive(TreeNode root) {

        if (root == null) {
            return;
        } else {
            printTreeRecursive(root.l);
            System.out.println(root.val);
            printTreeRecursive(root.r);
        }
    }

    public static void printTree(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            if (node.r != null) {
                stack.push(node.r);
            }
            System.out.println(node.val);
            if (node.l != null) {
                stack.push(node.l);
            }
        }
    }
}

















