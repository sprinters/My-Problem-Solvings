package main.leetcode;


import java.util.ArrayList;

public class UniqueBinarySearchTrees11 {

    public static void main(String...s) {
        UniqueBinarySearchTrees11 countBSTs =   new UniqueBinarySearchTrees11();
        TreeNode root   =   new TreeNode(-2);
        TreeNode x   =   new TreeNode(-3);
        TreeNode y   =   new TreeNode(11);
        TreeNode z   =   new TreeNode(7);
        TreeNode p   =   new TreeNode(2);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
        root.right      =   x;
        System.out.println(countBSTs.solve(3));
    }


    public ArrayList<TreeNode> solve(int n) {
        return generateTrees(1,n);
    }



    public ArrayList<TreeNode> generateTrees(int start,int end) {


        ArrayList<TreeNode> result  =   new ArrayList<TreeNode>();

        if(start > end) {
            result.add(null);
            return result;
        }


        for(int k=  start;k <= end ; k++) {

            ArrayList<TreeNode> leftTrees   =   generateTrees(start,k-1);
            ArrayList<TreeNode> rightTrees   =   generateTrees(k + 1,end);

            // till now we have generated all the left trees and right trees for the root k.


            for(TreeNode leftNode : leftTrees) {
                for(TreeNode rightNode : rightTrees) {

                    TreeNode root   =   new TreeNode(k);
                    root.left   =   leftNode;
                    root.right  =   rightNode;
                    result.add(root);

                }
            }


        }
        return result;


    }

}
