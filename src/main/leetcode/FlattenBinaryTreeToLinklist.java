package main.leetcode;


public class FlattenBinaryTreeToLinklist {

    public static void main(String...s) {
        FlattenBinaryTreeToLinklist flattenBinaryTreeToLinklist=    new
                FlattenBinaryTreeToLinklist();


        flattenBinaryTreeToLinklist.solve(new TreeNode(0));
    }

    private void solve(TreeNode treeNode) {
        TreeNode node   =   flatten(treeNode);

    }

    public TreeNode flatten(TreeNode root) {

        if(root ==  null) {
            return root;
        }


        TreeNode rightSubTree   =   root.right;

        if(root.left != null) {
            root.right  =   root.left;
            root.left   =   null;
            root    =   flatten(root.right);
        }


        if(rightSubTree != null) {
            root.right  =   rightSubTree;
            root    =   flatten(rightSubTree);
        }
        return root;
    }
}
