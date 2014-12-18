package main.leetcode;

public class MaxDepthOfBinaryTree {


    private static int answer   =   Integer.MIN_VALUE;
    public static void main(String...s) {
        MaxDepthOfBinaryTree pathSum =   new MaxDepthOfBinaryTree();
        TreeNode root   =   new TreeNode(-2);
        TreeNode x   =   new TreeNode(-3);
        TreeNode y   =   new TreeNode(11);
        TreeNode z   =   new TreeNode(7);
        TreeNode p   =   new TreeNode(2);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
        root.left=  x;
        x.left  =   y;
        y.left  =   z;
        y.right =   p;

        root.right  =   q;
        q.left      =   r;
        q.right     =   m;
        m.right     =   n;
        //root.right      =   x;
        System.out.println(pathSum.solve(root));
    }

    private int solve(TreeNode root) {
        return minDepth(root);
    }

    private int minDepth(TreeNode root) {

        if(root ==  null) {
            return 0;
        }

        if(root.left    ==  null && root.right  ==  null) {
            return 1;
        }
        answer =   Integer.MIN_VALUE;
        dfs(root,1);
        return answer;
    }

    private void dfs(TreeNode root,int currentMinDepth) {

        if (root.left   ==  null && root.right  ==  null) {
            answer =   Math.max(currentMinDepth,answer);
            return;
        }
        if(root.left != null) {
            dfs(root.left, currentMinDepth + 1);

        }
        if(root.right != null) {
            dfs(root.right, currentMinDepth + 1);

        }
    }
}
