package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Stack;

public class BinaryTreeToLinkedList {
    private static TreeNode head   =   null;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public void convertIntoDLL(TreeNode root,TreeNode parent) {
        Stack<TreeNode>  first   =   new Stack<TreeNode>();
        Stack<TreeNode>  second  =  new Stack<TreeNode>();

        while(root != null) {
            first.push(root.left);
            root    =   root.left;
        }

        // now we are at left most node,lets say this node x
        // now fetch parent of this node which will be second top element..lets say this node as y.
        // we are going to exchange pointer of x and y nodes.

        if(!first.empty()) {
            head    =   first.peek();
        }


        TreeNode x,y,z;
        while(first.size() > 1) {

            x       =   first.pop();
            y       =   first.pop();

            x.right     =   y;
            y.left      =   x;

            TreeNode l_root =   y.right;
            while(l_root != null) {
                first.push(l_root);
                l_root  =   l_root.left;
            }

            TreeNode l_root_fresh   =       first.peek();
            if(l_root_fresh != null) {
                y.right =   l_root_fresh;
                l_root_fresh.left =   y;
            }
        }
    }
}
