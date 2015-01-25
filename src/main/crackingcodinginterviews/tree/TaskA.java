package main.crackingcodinginterviews.tree;

import main.leetcode.TreeNode;

/**
 * * @author sandeepandey
 */
public class TaskA {

    public static void main(String...s) {
        TaskA taskA =   new TaskA();
        taskA.isBalanced(null);
    }


    public boolean isBalanced(TreeNode root) {

        return maxDepth(root)-minDepth(root) <= 0;
    }

    private int minDepth(TreeNode root) {
        if(root ==  null) {
            return 0;
        }

        return 1+Math.min(minDepth(root.left), minDepth(root.right));


    }

    private int maxDepth(TreeNode root) {

        if(root ==  null) {
            return 0;
        }

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
