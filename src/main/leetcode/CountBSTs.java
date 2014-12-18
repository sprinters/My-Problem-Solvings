package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountBSTs {
    Map<Integer,Integer> map    =   new HashMap<Integer,Integer>();
    public static void main(String...s) {
        CountBSTs countBSTs =   new CountBSTs();
        TreeNode root   =   new TreeNode(-2);
        TreeNode x   =   new TreeNode(-3);
        TreeNode y   =   new TreeNode(11);
        TreeNode z   =   new TreeNode(7);
        TreeNode p   =   new TreeNode(2);
        TreeNode q   =   new TreeNode(8);
        TreeNode r   =   new TreeNode(13);
        TreeNode m   =   new TreeNode(4);
        TreeNode n   =   new TreeNode(1);
        root.right      =   x;
        System.out.println(countBSTs.solve(3));
    }

    private int solve(int N) {
        return countTrees(N);
        
    }

    private int countTrees(int n) {

        if(map.containsKey(n)){
            return map.get(n);
        }
        if (n == 0){
            map.put(0,1);
            return 1;
        }
        if (n == 1) {
            map.put(1,1);
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n ;i++){
            result += countTrees(i) * countTrees(n-i-1);
        }
        map.put(n,result);
        return result;

    }

    private int numTrees(int n) {

        // look at the base cases
        if(map.containsKey(n)) {
            return map.get(n);
        }


        if(n ==  1 || n  ==  0) {
            map.put(n,1);
            return 1;
        }

        int result  =   0;
        for(int i   =   0;i < n ; i++) {
            result  += numTrees(i) * numTrees(n-1-i);
        }
        return result;

    }
}
