package main.codechef.monthly.MAY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.*;


public class BruteBalloons {

    private static List<ArrayList<Integer>> glist  =   new ArrayList<ArrayList<Integer>>();
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        glist.clear();
        int N   =   in.readInt();
        int M   =   in.readInt();
        int[] colorAt   =   new int[N];
        int[] costAt    =   new int[N];


        for(int i   =   0;i < N ; i++) {
            colorAt[i]  =   in.readInt();
            costAt[i]   =   in.readInt();
        }

        Map<Integer,Integer> l_map  =   new HashMap<Integer, Integer>();

        for(int i   =   0;i < N ; i++) {
            l_map.put(colorAt[i],costAt[i]);
        }
        generateSubset(colorAt);
        out.printLine(glist);
        ArrayList<ArrayList<Integer>> newList   =   new ArrayList<ArrayList<Integer>>();
        Set<Integer> mySet  =   new HashSet<Integer>();

        for(ArrayList<Integer> list : glist) {

            mySet.addAll(list);
            if(mySet.size()>= M) {
                newList.add(list);
            }
            mySet.clear();
        }

        out.printLine(newList);
        double fromDivide   =   newList.size();
        double toDivide     =   0;

        for(ArrayList<Integer> list : newList) {

            for(Integer i : list) {
                toDivide += l_map.get(i);
            }
        }



        out.printLine("toDivide::"+toDivide+" fromDivide::"+fromDivide);
        out.printLine(toDivide/fromDivide);
    }


    public void generateSubset(int[] array) {
        boolean[] used  =   new boolean[array.length];
        Arrays.fill(used, false);
        dfs(0,array.length-1,array,used);
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

            glist.add(subList);
            return;
        }


        used[start] =   true;
        dfs(start+1,end,s,used);
        used[start] =   false;
        dfs(start+1, end, s, used);

    }
}
