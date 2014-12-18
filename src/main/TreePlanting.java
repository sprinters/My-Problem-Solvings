package main;

import main.api.my.utils.array.ArrayUtils;

public class TreePlanting {

    public long countArrangements(int total, int fancy) {


        long[][] dp  =   new long[total + 1][fancy + 1];

        ArrayUtils.fill(dp,0);

        /**
         * This is dynamic programming problem
         * f(p,f) ..> number of ways of placing f fancy tree upto p position
         *
         * f(p,f) = put fancy tree at pth pos + put plain tree at pth pos
         *        = f(p-2,f-1) + f(p-1,f)
         *
         *
         * what are the base case ?
         *
         * f(1,1) = 1
         * f(0,0) = 1
         */

        dp[0][0]    =   1;

        for(int pos =   1 ; pos <= total ; pos++) {

            for(int fTree   =   0;fTree <= fancy ; fTree++) {

                if(pos == 1 && fTree == 1) {
                    dp[pos][fTree]  =   1;
                    continue;
                }

                if(fTree    ==  0) {
                    dp[pos][fTree]  =   1;
                    continue;
                }

                dp[pos][fTree] += dp[pos-1][fTree];

                if( (pos-2) >= 0  &&  (fTree -1) >= 0) {
                    dp[pos][fTree]+=dp[pos-2][fTree-1];
                }
            }
        }

        return dp[total][fancy];

    }
}
