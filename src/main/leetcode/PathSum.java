package main.leetcode;

public class PathSum {


    public static void main(String...s) {
        PathSum pathSum =   new PathSum();
        TreeNode root   =   new TreeNode(-2);
        TreeNode x   =   new TreeNode(-3);
        TreeNode y   =   new TreeNode(11);
        TreeNode z   =   new TreeNode(7);
        TreeNode p   =   new TreeNode(2);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
//        root.left=  x;
//        x.left  =   y;
//        y.left  =   z;
//        y.right =   p;
//
//        root.right  =   q;
//        q.left      =   r;
//        q.right     =   m;
//        m.right     =   n;
        root.right      =   x;
        System.out.println(pathSum.solve(root, -2) ? "YES" : "NO");
    }

    private boolean solve(TreeNode root, int targetSum) {
       return  hasPathSum(root,targetSum);
    }

    private boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==   null) {
            if(targetSum    ==  0) {
                return true;
            }
            return false;
        }

        if(root.left    ==  null && root.right == null) {
            return root.val ==  targetSum;
        }

       return hasPathSum(root,targetSum,0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {


        //if we are at leaf node
        if(root.left == null && root.right  == null) {
            currentSum  =   currentSum + root.val;

            System.out.println("Found Sum At leaf::"+currentSum);
            if(currentSum   ==  targetSum) {
                return true;
            }
            return false;
        }

        boolean leftOkay  = false,rightOkay=false;
        if(root.left != null) {
            leftOkay    =   hasPathSum(root.left,targetSum,currentSum+root.val);
        }

        if(root.right != null) {
            rightOkay=hasPathSum(root.right,targetSum,currentSum+root.val);
        }

        return leftOkay ==  true || rightOkay   ==  true;

      //  return true;

    }





}
