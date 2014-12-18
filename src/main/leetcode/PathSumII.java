package main.leetcode;

import java.util.ArrayList;

public class PathSumII {

    public static void main(String...s) {
        PathSumII pathSum =   new PathSumII();
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
        System.out.println(pathSum.solve(root, 22) );
    }


    public ArrayList<ArrayList<Integer>> solve(TreeNode root, int targetSum) {
        return  hasPathSum(root,targetSum);
    }

    public ArrayList<ArrayList<Integer>> hasPathSum(TreeNode root, int targetSum) {

        ArrayList<ArrayList<Integer>> result    =   new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>  helperList  =   new ArrayList<Integer>();
        if(root==   null) {
            return result;
        }

        if(root.left    ==  null && root.right  ==  null) {
            if(targetSum    ==  root.val) {
                helperList.add(root.val);
                result.add(helperList);
            } else {
                return result;
            }
            return result;
        }

        dfs(root,targetSum,0,helperList,result);
        return result;


    }

    private void dfs(TreeNode root, int targetSum, int currentSum, ArrayList<Integer> helperList,
                     ArrayList<ArrayList<Integer>> result) {

        // we are at leaf
        if(root.left    ==  null && root.right  ==  null) {

            currentSum  =   currentSum + root.val;
            if(currentSum   ==  targetSum) {
                ArrayList<Integer>  newList =   new ArrayList<Integer>(helperList);
                newList.add(root.val);
                result.add(newList);
            }
            return ;
        }
        boolean okay        =   false;


        if(root.left != null) {
            okay    =   true;
            helperList.add(root.val);
            dfs(root.left, targetSum, currentSum + root.val, helperList, result);
        }

        if(root.right != null) {


            if(root.left == null) {
                helperList.add(root.val);
            }

            dfs(root.right,targetSum,currentSum+root.val,helperList,result);
        }
        helperList.remove(helperList.size()-1);

    }
}
