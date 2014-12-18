package main.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sandeepandey
 * Date: 18/1/14
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SameTree {

    public static void main(String...s) {
        SameTree pathSum =   new SameTree();
        TreeNode root   =   new TreeNode(3);
        TreeNode x   =   new TreeNode(9);
        TreeNode y   =   new TreeNode(20);
        TreeNode z   =   new TreeNode(15);
        TreeNode p   =   new TreeNode(7);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
        root.left=  x;
        root.right  =   y;

        y.left  =   z;
        y.right =   p;
        System.out.println(pathSum.solve(root, new TreeNode(23)) ? "YES" : "NO");
    }

    public boolean solve(TreeNode first,TreeNode second) {

        if(first    ==  null) {
            return second==null;
        }
        boolean isLeftSame  =   false;
        boolean isRightSame =   false;
        isLeftSame  =   (first.val   ==  second.val) && (solve(first.left,second.left));
        isRightSame =   (first.val   ==  second.val) && (solve(first.right,second.right));
        return isLeftSame && isRightSame;
    }

}
