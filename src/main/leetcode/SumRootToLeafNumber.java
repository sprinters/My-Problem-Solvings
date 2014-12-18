package main.leetcode;


import javax.xml.transform.sax.SAXSource;

public class SumRootToLeafNumber {

    private static long totalSum    =   0;
    public int sumNumbers(TreeNode root) {
        totalSum    =   0;
        TreeNode superRoot  =   new TreeNode(0);
        superRoot.left  =   root;
        superRoot.right =   null;

        dfs(superRoot,root,0);
        return (int) totalSum;
    }

    private void dfs(TreeNode parent, TreeNode child, int currentSum) {

        if(child    ==  null) {
            return;
        }
        if(child.left    ==  null && child.right    ==  null) {
            totalSum+=currentSum * 10 + child.val;
            return;
        }

        dfs(child,child.left,currentSum*10+child.val);
        dfs(child,child.right,currentSum*10 + child.val);
    }


    public static void main(String...s) {
        SumRootToLeafNumber helper  =   new SumRootToLeafNumber();
        // build a tree

        TreeNode root   =   new TreeNode(4);
        TreeNode left   =   new TreeNode(9);
        TreeNode right  =   new TreeNode(0);
        TreeNode x      =   new TreeNode(1);
        TreeNode y      =   new TreeNode(5);

        root.left  =   left;
        left.left   =   right;
        root.right =   x;
//        right.left  =   y;
//        right.right =   x;

        System.out.println(helper.sumNumbers(root));

    }


}
