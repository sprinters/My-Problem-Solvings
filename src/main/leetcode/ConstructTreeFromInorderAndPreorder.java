package main.leetcode;

public class ConstructTreeFromInorderAndPreorder {
    private static int preIndex =   0;
    public static void main(String...s) {
        ConstructTreeFromInorderAndPreorder runner  =   new
                ConstructTreeFromInorderAndPreorder();


        int[] inArray   =   new int[0];
        int[] preArray  =   new int[0];
        System.out.println(runner.solve(inArray,preArray));
    }

    private TreeNode solve(int[] inArray, int[] preArray) {
        preIndex    =   0;
        return buildTree(inArray,preArray);
    }

    public TreeNode buildTree(int[] inArray, int[] preArray) {
        return buildTree(inArray,0,inArray.length-1,preArray,0,preArray.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd) {


        if(inStart > inEnd) {
            return null;
        }

        int val =   preOrder[preIndex++];
        TreeNode root   =   new TreeNode(val);
        if(inStart == inEnd) {
            return root;
        }

        // find this value in inorder array

        int inIndex =   find(inorder,inStart,inEnd,val);

        root.left   =   buildTree(inorder, inStart, inIndex-1, preOrder, preStart+1, preEnd) ;
        root.right  =   buildTree(inorder, inIndex+1, inEnd, preOrder, preStart+1, preEnd);
        return root;

    }

    private int find(int[] inorder, int inStart, int inEnd, int target) {

        for(int i   =   inStart ; i <= inEnd ; i++) {

            if(target   ==  inorder[i]) {
                return i;
            }
        }

        return inStart;
    }
}
