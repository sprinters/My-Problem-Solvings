package main.crackingcodinginterviews.tree;

import main.leetcode.TreeNode;

/**
 * * @author sandeepandey
 */
public class TaskC {

    private static int TWO_NODES_FOUND  =   2;
    private static int ONE_NODE_FOUND   =   1;
    private static int ZERO_NODE_FOUND  =   0;
    public static void main(String...s) {
        TaskC taskC =   new TaskC();

    }

    /**
     *
     * @param root
     * @param first
     * @param second
     * @return
     */
    public TreeNode solveByApproachOne(TreeNode root,TreeNode first,TreeNode second) {
        return null;
    }


    /**
     *
     * @param root
     * @param first
     * @param second
     * @return
     */
    public TreeNode solveByApproachTwo(TreeNode root,TreeNode first,TreeNode second) {

        if(covers(root.left,first) && covers(root.left,second)) {
            return solveByApproachTwo(root.left,first,second);
        }
        else if(covers(root.right,first) && covers(root.right,second)) {
            return solveByApproachTwo(root.right,first,second);
        }
        return root;
    }

    /**
     *
     * @param root
     * @param first
     * @param second
     * @return
     */
    public TreeNode solveByApproachThree(TreeNode root,TreeNode first,TreeNode second) {

        //case when first and second node is equal
        if( (first == second) && (root.left ==  first || root.right == first)) {
            return root;
        }
        int nodesFromLeft   =   covers(root.left,first,second);
        if(nodesFromLeft    ==  TWO_NODES_FOUND) {

            if(root.left   ==   first || root.left == second) {
                return root.left;
            }
            return solveByApproachThree(root.left,first,second);
        } else {

            if(nodesFromLeft == ONE_NODE_FOUND) {
                if(root == first) {
                    return first;
                } else if(root == second) {
                    return second;
                }
            }
        }
        int nodesFromRight  =   covers(root.right,first,second);
        if(nodesFromRight   ==  TWO_NODES_FOUND) {

            if(root.right   ==  first || root.right ==  second) {
                return root.right;
            }

            return solveByApproachThree(root.right,first,second);
        }  else {
             if(nodesFromLeft    ==  ONE_NODE_FOUND) {
                if(root ==  first) {
                    return first;
                } else if(root == second) {
                    return second;
                }
            }
        }
        if(nodesFromLeft    ==  ONE_NODE_FOUND && nodesFromRight    ==  ONE_NODE_FOUND) {
            return root;
        }
        return null;
    }

    /**
     *
     * @param root
     * @param toLook
     * @return
     */
    private static boolean covers(TreeNode root,TreeNode toLook) {
        if(root ==  null) return false;
        if(root ==  toLook) {
            return true;
        }
        return covers(root.left,toLook) || covers(root.right,toLook);
    }

    /**
     *
     * @param root
     * @param first
     * @param second
     * @return
     */
    private int covers(TreeNode root,TreeNode first,TreeNode second) {
        int result  =   ZERO_NODE_FOUND;
        if(root == null) {
            return result;
        }
        if(root == first || root    ==  second) {
            result+=ONE_NODE_FOUND;
        }
        result += covers(root.left,first,second);
        if(result   ==  TWO_NODES_FOUND) {
            return result;
        }
        return result + covers(root.right,first,second);
    }

}
