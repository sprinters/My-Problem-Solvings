package main.leetcode;

import java.util.Stack;

public class IterativeInorderTraversalForBinaryTree {

    public static void main(String...s) {
        IterativeInorderTraversalForBinaryTree  runner  =   new
                IterativeInorderTraversalForBinaryTree();
        EnrichedTreeNode node   =   new EnrichedTreeNode(0,false);
        runner.doTraversal(node);
    }

    private void doTraversal(EnrichedTreeNode node) {

        Stack<EnrichedTreeNode> stack   =   new Stack<EnrichedTreeNode>();
        stack.push(node);

        while(!stack.isEmpty()) {

            EnrichedTreeNode top    =   stack.peek();

            if(top != null) {

                if(!top.isVisited) {
                    stack.push(top.left);
                } else {
                    System.out.println(" "+top.val);
                    stack.pop();
                    stack.push(top.right);
                }
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    stack.peek().isVisited  =   true;
                }
            }
        }
    }
}
