package net.xonich.problems;

import net.xonich.problems.PrintTree.TreeNode;
import org.junit.jupiter.api.Test;

class PrintTreeTest {

    @Test
    public void shouldPrintSimpleTree() {

        TreeNode root = new TreeNode();
        root.val = "4";
        TreeNode childOne = new TreeNode();
        childOne.val = "2";
        TreeNode childTwo = new TreeNode();
        childTwo.val = "5";
        TreeNode childFour = new TreeNode();
        childFour.val = "1";
        TreeNode childFive = new TreeNode();
        childFive.val = "3";
        TreeNode childSix = new TreeNode();
        childSix.val = "6";

        root.l = childOne;
        root.r = childTwo;
        childOne.l = childFour;
        childOne.r = childFive;
        childTwo.r = childSix;

//        PrintTree.printTree(root);
        PrintTree.printTreeBroad(root);
    }
}