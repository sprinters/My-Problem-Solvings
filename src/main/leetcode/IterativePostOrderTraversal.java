package main.leetcode;


import java.util.ArrayList;
import java.util.Stack;

public class IterativePostOrderTraversal {
    public static void main(String...s) {
        IterativePostOrderTraversal runner   =   new IterativePostOrderTraversal();
        TreeNode root   =   new TreeNode(0);


        System.out.println(runner.solve(root));
    }

    public ArrayList<Integer> solve(TreeNode root) {
        return postorderTraversal(root);
    }


    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result       =   new ArrayList<Integer>();
        Stack<TreeNode> treeNodeStack   =   new Stack<TreeNode>();


        do {
            while(root != null) {
                if(root.right != null) {
                    treeNodeStack.push(root.right);
                }
                treeNodeStack.push(root);
                root   =   root.left;
            }

            root       =   treeNodeStack.pop();

            if(root.right != null && treeNodeStack.peek().val == root.right.val) {
                treeNodeStack.pop();
                treeNodeStack.push(root);
                root=   root.right;
            } else {
                result.add(root.val);
                root    = null;
            }

        } while(!treeNodeStack.isEmpty());

        return result;
    }
}
