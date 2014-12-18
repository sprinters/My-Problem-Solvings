package test.on2014_05.on2014_05_20_Single_Round_Match_621.NumbersChallenge;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumbersChallenge {


    private static Set<Long> lookUp    =   null;


    public int MinNumber(int[] S) {
        lookUp  =   new HashSet<>();
        int start  =   0;

        boolean[] used  =   new boolean[S.length];
        Arrays.fill(used,false);


        System.out.println(lookUp);
        dfs(0,S.length-1,S,used);


        while(true) {

            if(!lookUp.contains(Long.valueOf(start))) {
                return start;

            }

            start++;

        }



    }



    private void dfs(int start, int end, int[] array, boolean[] used) {


        if(start    > end) {
            long sum    =   0;

            for(int i   =   0;i < used.length ; i++) {

                if(used[i]) {
                    sum += array[i];
                }

            }
            lookUp.add(sum);
            return;
        }


        used[start] =   true;
        dfs(start+1,end,array,used);
        used[start] =   false;
        dfs(start+1, end, array, used);

    }


    }



