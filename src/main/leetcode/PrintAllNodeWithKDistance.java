package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class PrintAllNodeWithKDistance {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        TreeNode root   =   new TreeNode(20);
        root.left   =   new TreeNode(8);
        root.left.left  =   new TreeNode(4);
        root.left.right =   new TreeNode(12);
        root.left.right.left    =   new TreeNode(10);
        root.left.right.right    =   new TreeNode(14);
        root.right  =   new TreeNode(22);

        TreeNode target =   root.left.right;
        int K   =   2;

        solve(root,target,K,out);

    }

    private void solve(TreeNode root, TreeNode target, int k,OutputWriter out) {
        System.out.println("Going to Run");

        solver(root,target,k,out);

    }

    private int solver(TreeNode root, TreeNode target, int k, OutputWriter out) {

        if(root     ==  null) {
            return -1;
        }

        if(root     ==  target) {
            out.printLine("Found Target::"+root.val);
            printAllNodeAtDistanceKRootedAtRoot(root,k,out);
            return 0;
        }

        int leftDistance    =   solver(root.left, target, k, out);
        out.printLine("Left Recursion is stop for::"+root.val);
        out.printLine("leftDistance is::"+leftDistance);
        if(leftDistance !=  -1) {
            if(leftDistance + 1 == k) {
                out.printLine(root.val);

            } else {
               printAllNodeAtDistanceKRootedAtRoot(root.right,k-leftDistance-2,out);
            }
            return leftDistance+1;
        }

        int rightDistance   =   solver(root.right,target,k,out);
        out.printLine("Right Recursion is stop for::"+root.val);
        out.printLine("rightDistance is::"+rightDistance);

        if(rightDistance != -1) {

            if(rightDistance+1  ==  k) {
                out.printLine(root.val);
            }  else {
                printAllNodeAtDistanceKRootedAtRoot(root.left,k-rightDistance-2,out);
            }
            return rightDistance+1;
        }

        return -1;
    }

    private void printAllNodeAtDistanceKRootedAtRoot(TreeNode root, int k,OutputWriter out) {
        if(root ==  null) {
            return;
        }

        if(k    ==  0) {
            out.printLine(root.val);

        }

        printAllNodeAtDistanceKRootedAtRoot(root.left,k-1,out);
        printAllNodeAtDistanceKRootedAtRoot(root.right,k-1,out);
    }
}
