package main.crackingcodinginterviews.tree;

import main.leetcode.TreeNode;

/**
 * * @author sandeepandey
 */
public class TaskB {


    public static void main(String...s) {
        TaskB taskB =   new TaskB();
        int[] array =   {1,2,3};
        TreeNode root = toMinimalHeightOfBinaryTree(array,0,array.length-1);
        System.out.println(root);
    }

    public static TreeNode toMinimalHeightOfBinaryTree(int[] array,int start,int end) {

        if(start > end) {
            return null;
        }

        int mid =   (start + end) >> 1;
        TreeNode root   =   new TreeNode(array[mid]);
        root.left       =   toMinimalHeightOfBinaryTree(array,start,mid-1);
        root.right      =   toMinimalHeightOfBinaryTree(array,mid+1,end);
        return root;
    }
}
