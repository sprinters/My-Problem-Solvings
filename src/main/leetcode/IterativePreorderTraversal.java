package main.leetcode;

import java.util.ArrayList;
import java.util.Stack;


public class IterativePreorderTraversal {


    public static void main(String...s) {
        IterativePreorderTraversal runner   =   new IterativePreorderTraversal();
        TreeNode root   =   new TreeNode(0);


        System.out.println(runner.solve(root));
    }

    public ArrayList<Integer> solve(TreeNode root) {
        return preorderTraversal(root);
    }


    public ArrayList<Integer> preorderTraversal(TreeNode root) {


        if(root ==  null) {
            return null;
        }
        Stack<TreeNode> treeNodeStack   =   new Stack<TreeNode>();
        treeNodeStack.push(root);


        // we are going to print pre order traversal
        // preorder follows left root right
        // our alogorithm will be follow as
        // push root,then right and finally left

        ArrayList<Integer> result   =   new ArrayList<Integer>();
        while(!treeNodeStack.isEmpty()) {
            TreeNode topOfStack =   treeNodeStack.peek();

            result.add(topOfStack.val);
            treeNodeStack.pop();

            //if right child is not null,then insert this right child
            if(topOfStack.right != null) {
                treeNodeStack.push(topOfStack.right);
            }

            //if right child is not null,then insert this right child
            if(topOfStack.left != null) {
                treeNodeStack.push(topOfStack.left);
            }

        }

       return result;
    }
}
