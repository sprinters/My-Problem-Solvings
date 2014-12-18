package main.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {

    private static ArrayList<ArrayList<Integer>> result =   null;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        result          =   new ArrayList<ArrayList<Integer>>();
        boolean[] used  =   new boolean[S.length];
        Arrays.fill(used,false);

        dfs(0, S.length - 1, S, used) ;
        return result;


    }

    private void dfs(int start, int end, int[] s, boolean[] used) {


        if(start    > end) {
            ArrayList<Integer> subList  =   new ArrayList<Integer>();
            for(int i   =   0;i < used.length ; i++) {
                if(used[i]) {
                    subList.add(s[i]);
                }
            }
            Collections.sort(subList);
            result.add(subList);
            return;
        }


        used[start] =   true;
        dfs(start+1,end,s,used);
        used[start] =   false;
        dfs(start+1, end, s, used);

    }

}
