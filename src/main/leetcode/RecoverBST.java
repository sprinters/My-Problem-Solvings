package main.leetcode;

public class RecoverBST {


    private TreeNode first  =   null;
    private TreeNode second =   null;
    private TreeNode prev   =   null;
    public static void main(String...s) {
        RecoverBST runner   =   new RecoverBST();
        TreeNode root   =   new TreeNode(0);
        runner.solve(root);
    }

    private void solve(TreeNode root) {

        recoverTree(root);
    }


    /**
     * Wht is idea here ?
     * we will maintain three pointer here.
     * first ---> this will point to the first corrupted node
     * second --> this will point to the second corrupted node
     * current --> this will point to the current node ,from which we are moving here and there.
     * @param root
     */
    public void recoverTree(TreeNode root) {

        first   =   null;
        second  =   null;
        prev    =   null;
        recoverTreeHelper(root);

        // now just swap two nodes

        if(first != null && second != null) {
            int dummy   =   first.val;
            first.val   =   second.val;
            second.val  =   dummy;
        }

    }

    /**
     * This will first recurse for the left  most node to find the start point of the inorder traversal.
     * if you found left most node ..then say this will be prev node..now will try to adavnce this node
     * to current node.whenever you got the condition like prev.val > current.val...say this is the first
     * node which may be wrong.store it in first variable.and say second is current node.now till we have
     * found one wrong node.
     *
     *
     *
     * @param current
     */
    private void recoverTreeHelper(TreeNode current) {

        // Think base cases for stopping recursion
        // If you found that current node is null..then just return it.


        if(current  ==  null) {
            return;
        }
        else {
            // recurse for left most node
            recoverTreeHelper(current.left);

            // you are at very first node of tree traversal
            // just check this condition

            if(prev ==  null) {
                prev    =   current;
            }  else {

                if(prev.val > current.val) {

                    //if this is first wrong node
                    // just say you have found first wrong node
                    if(first    ==  null) {
                        first   =   prev;
                    }

                    second  =   current;
                }

                prev    =   current;

            }
            recoverTreeHelper(current.right);
        }
    }

}
