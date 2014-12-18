package main;

import main.api.my.utils.array.ArrayUtils;

public class Books {
    public int sortMoves(String[] titles) {

        /**
         * This problem can be converted into some standard dynamic programming.
         * lets suppose we have all 2^n subsets of title.
         * now consider erase of any subset say x from all subsets.
         * lets suppose perform the activity of y --> erasing subset x from the 2^n subsets
         *
         *
         * okay..so there are two possibility.
         *
         * > After performing activity y ..remaining element may be in desired order.
         * if they are are already in desired order..then we have to just put this
         * subset x in some desired manner.
         *
         * > After performing activity y...remaining element may not be in desired order.
         * Then it is clearly impossible to arrange them..
         *
         * so basically the problem is we have to remove min ( possibly zero or more) element such that
         * remaining sequence become in increasing order.
         *
         * so in nutshell we have to find longest increasing sub sequence .
         */

//
//        int compareStatus   =   "the return of the king".compareTo("the fellowship of the ring");
//
//
//        System.out.println("Status is::"+compareStatus);

        int[] dp    =   new int[titles.length];

        dp[0]       =   1;
        for(int current   =   1 ; current < titles.length ; current++) {

            int tmpLis  =   0;
            for(int back    =  current-1 ; back >= 0  ; back--) {
                if(titles[current].compareTo(titles[back]) >= 0) {
                    tmpLis  =   Math.max(tmpLis,dp[back]);
                }
            }

            //System.out.println("found lis at::"+(tmpLis + 1));
            dp[current] =   tmpLis + 1;
        }




        return titles.length- ArrayUtils.maxElement(dp);
    }


    public int compareToAnd(String first,String second) {
        return first.compareTo(second);
    }

}
