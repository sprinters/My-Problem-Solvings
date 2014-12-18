package main.leetcode;


public class ValidateBST {

    public static void main(String...s) {
        ValidateBST bstHelper   =   new ValidateBST();
        bstHelper.validate(new TreeNode(0));
    }

    private boolean validate(TreeNode root) {
        return   isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue,int maxValue) {
        if(root==   null) {
            return true;
        }
        if(root.val < minValue || root.val > maxValue) {
            return false;
        }
        return isValidBST(root.left,minValue,root.val) && isValidBST(root.right,root.val,maxValue);

    }
}
