package main.crackingcodinginterviews.tree;

import main.leetcode.TreeNode;

/**
 * * @author sandeepandey
 */
public class TaskD {

    public static void main(String...s) {

    }

    /**
     *
     * @param big
     * @param small
     * @return
     */
    public boolean containsTree(TreeNode big,TreeNode small) {

        if(small    ==  null) {
            return true;
        }
        return isSubTree(big,small);


    }

    /**
     *
     * @param first
     * @param second
     * @return
     */
    private boolean isSubTree(TreeNode first, TreeNode second) {

        if(first == null) {
            return true;
        }

        if(first.val    ==  second.val) {
            if(match(first,second)) {
                return true;
            }
        }

        return isSubTree(first.left,second) || isSubTree(first.right,second);
    }

    //----------------------------------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @return
     */
    private boolean match(TreeNode first, TreeNode second) {

        if(first == null && second == null) {
            return true;
        }

        if(first == null || second == null) {
            return false;
        }

        return (first.val == second.val) && match(first.left,second.left) && match(first.right,second.right);
    }



}
