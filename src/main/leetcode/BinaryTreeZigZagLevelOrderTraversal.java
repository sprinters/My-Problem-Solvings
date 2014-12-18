package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeZigZagLevelOrderTraversal {

    public static void main(String...s) {
        BinaryTreeZigZagLevelOrderTraversal pathSum =   new BinaryTreeZigZagLevelOrderTraversal();
        TreeNode root   =   new TreeNode(3);
        TreeNode x   =   new TreeNode(9);
        TreeNode y   =   new TreeNode(20);
        TreeNode z   =   new TreeNode(15);
        TreeNode p   =   new TreeNode(7);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
        root.left=  x;
        root.right  =   y;

        y.left  =   z;
        y.right =   p;
        System.out.println("Level Order Traversal Result::"+pathSum.solve(root));
    }

    private ArrayList<ArrayList<Integer>>  solve(TreeNode root) {
        Queue<TreeNode> bfsQueue   =   new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result    =   new ArrayList<ArrayList<Integer>>();


        if(root==null) {
            return result;
        }

        if(root.left    ==  null && root.right  ==  null) {
            ArrayList<Integer> subResultList    =   new ArrayList<Integer>();
            subResultList.add(root.val);
            result.add(subResultList);
            return result;
        }


        /**
         * So Wht do you think till now...
         * here we are maintaining count information.
         *  > nodeCountAtCurrentLevel : this info will how many node
         *  are in current level.
         *
         *  while traversing all node at currentLevel..we try to fetch information of next level.
         *  i.e we try to update nodeCountAtNextLevel.
         *
         *
         *  now we reassign nodeCountAtNextLevel to nodeCountAtCurrentLevel.
         */
        bfsQueue.add(root);

        //first level must have only one node..i.e root node
        int nodeCountAtCurrentLevel =   1;

        // we dont know nodeCountAtNextLevel yet ? so will try to get some information
        // while traversing all node present in the currentLevel.
        int nodeCountAtNextLevel    =   0;
        boolean leftToRight         =   true;
        boolean rightToLeft         =   false;
        ArrayList<Integer> subList  =   null;


        // remain in loop while queue is not empty
        while( !bfsQueue.isEmpty()) {


            // you are going to traverse currentLevel.
            // so you must have information of these nodes.keep track of these nodes in  list.
            // so creating new list.
            subList  =   new ArrayList<Integer>();

            // count of nodes which we have to traverse from the bfsQueue.
            int count   =   nodeCountAtCurrentLevel;
            while(count > 0) {

                /**
                 * remove the child node
                 */
                TreeNode child  =   bfsQueue.poll();

                // see left of this child ?
                if(child.left!=null) {

                    // update nodeCount for next level
                    nodeCountAtNextLevel++;
                    bfsQueue.add(child.left);
                }

                // se right of this child
                if(child.right != null) {

                    // update nodeCount for next level
                    nodeCountAtNextLevel++;
                    bfsQueue.add(child.right);
                }
                // tracker of the current level
                subList.add(child.val);
                count--;
            }


            /**
             * now we have traverse current level completely.
             * and we gather information of nodeCount for next Level.
             *
             * now update nodeCountAtCurrentLevel to nodeCountAtNextLevel
             *
             **/
            nodeCountAtCurrentLevel =   nodeCountAtNextLevel;
            nodeCountAtNextLevel    =   0;
            if(!subList.isEmpty()) {

                if(rightToLeft) {
                    Collections.reverse(subList);
                }
                result.add(subList);
            }

            if(leftToRight) {
                rightToLeft =   true;
                leftToRight =   false;
            }

            if(rightToLeft) {
                leftToRight =   true;
                rightToLeft =   false;
            }
        }

        return result;
    }


}
