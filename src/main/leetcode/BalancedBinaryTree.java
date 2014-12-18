package main.leetcode;


public class BalancedBinaryTree {

    public static void main(String...s) {
        BalancedBinaryTree pathSum =   new BalancedBinaryTree();
        TreeNode root   =   new TreeNode(5);
        TreeNode x   =   new TreeNode(4);
        TreeNode y   =   new TreeNode(11);
        TreeNode z   =   new TreeNode(7);
        TreeNode p   =   new TreeNode(2);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
        TreeNode rr   =   new TreeNode(5);
        root.left=  x;
        x.left  =   y;
        y.left  =   z;
        y.right =   p;

        root.right  =   q;
        q.left      =   r;
        q.right     =   m;
        m.right     =   n;
        m.left      =   rr;
        //  root.right      =   x;
        System.out.println(pathSum.solve(root));
    }

    private boolean solve(TreeNode root) {
        return dfs(null,root,0,0,true);

    }

    private boolean dfs(TreeNode parent,TreeNode child,int leftDepth,int rightDepth,boolean isHightBalance) {
       return true;
    }
}
