package main.leetcode;


public class ConstructBinaryTreeFromInorderAndPostorder {
    private static  int postIndex   =   0;
    public static void main(String...s) {
        ConstructBinaryTreeFromInorderAndPostorder runner  =   new
                ConstructBinaryTreeFromInorderAndPostorder();


        int[] inArray   =   new int[0];
        int[] preArray  =   new int[0];
        System.out.println(runner.solve(inArray,preArray));
    }

    private TreeNode solve(int[] inArray, int[] preArray) {
         return buildTree(inArray,preArray);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex    =   postorder.length-1;
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }


    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {


        if(inStart > inEnd) {
            return null;
        }

        int val =   postorder[postIndex--];
        TreeNode root   =   new TreeNode(val);
        if(inStart == inEnd) {
            return root;
        }

        // find this value in inorder array

        int inIndex =   find(inorder,inStart,inEnd,val);
        root.right  =   buildTree(inorder, inIndex+1, inEnd, postorder, postStart+1, postEnd);
        root.left   =   buildTree(inorder, inStart, inIndex-1, postorder, postStart+1, postEnd) ;

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
