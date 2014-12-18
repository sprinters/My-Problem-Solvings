package main.leetcode;


public class SymmetricTree {

    public  static void main(String...s) {
        SymmetricTree tree   =   new SymmetricTree();

        tree.solve(new TreeNode(0));
    }

    private boolean solve(TreeNode treeNode) {
        return isSymmetric(treeNode);
    }

    public boolean isSymmetric(TreeNode root) {

        if(root     ==  null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        if(root.left== null || root.right == null) {
            return false;
        }

        return isSymmetric(root.left,root.right);


    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if(left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return  false;
        }

        boolean first   =   isSymmetric(left.left,right.right);
        boolean second  =   isSymmetric(left.right,right.left);

        if(first && second) {
            if(left.val == right.val) {
                return true;
            }

        }
       return false;
    }
}
