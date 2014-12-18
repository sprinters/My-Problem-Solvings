package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {

    private static ArrayList<ArrayList<Integer>> result =   null;

    public static void main(String...s) {
        Combinations run  =   new Combinations();
//        System.out.println("After combination::"+ run.combine(2,1));

    }
    public ArrayList<ArrayList<Integer>> combine(int n,int k) {

        result  =   new ArrayList<ArrayList<Integer>>();
        boolean[] used  =   new boolean[n];
        Arrays.fill(used,false);

        dfs(0,n,k,used);
        return result;
    }

    private void dfs(int start, int end, int count, boolean[] used) {



        if(count    <=  0) {
            ArrayList<Integer> subList  =   new ArrayList<Integer>();
            for(int i   =   0;i < used.length ; i++) {
                if(used[i]) {
                    subList.add(i+1);
                }
            }
         //   System.out.println("Collected SUb list is::"+subList);
            result.add(subList);
            return ;
        }


        if(start >= end) {
            return;
        }

        used[start] =   true;
        dfs(start+1,end,count-1,used);
        used[start] =   false;
        dfs(start+1,end,count,used);
    }


}
