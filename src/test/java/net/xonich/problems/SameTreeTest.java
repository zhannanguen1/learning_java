package net.xonich.problems;

import net.xonich.problems.SameTree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SameTreeTest {

    @Test
    public void sameTreeTest() {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        Assertions.assertTrue(SameTree.isSameTree(root, root2));
    }

    @Test
    public void notSameTreeTest() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);


        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        Assertions.assertFalse(SameTree.isSameTree(root, root2));
    }

    @Test
    public void notSameTreeTest1() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        Assertions.assertFalse(SameTree.isSameTree(root, root2));
    }
}
