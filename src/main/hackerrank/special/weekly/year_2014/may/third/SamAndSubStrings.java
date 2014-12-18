package main.hackerrank.special.weekly.year_2014.may.third;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;

public class SamAndSubStrings {

    private static final int MOD    =   1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] array    =   in.readString().toCharArray();
        long[] dp       =   new long[array.length];

        /**
         *
         * lets take the example to get the idea of the recurrence
         *
         * String input = 5312
         * total substring will be like this.
         *
         * 5|3|1|2|53|31|12|531|312|5312
         *  now after some rearrange :
         *
         * 5|3 53 | 1 31 531 | 2 12 312 5312
         *
         * f(4) =   2 + 13 + 312 + 5312
         *      =   2 + 10 + 2 + 310 + 2 + 5310 + 2
         *      =   4*2 + 10 (1 + 31 + 531)
         *      =   4*array[i] + 10 * dp[i-1]
         *      =   (i+1) * array[i] + 10 * dp[i-1]
         *
         * dp[i] >> will represent sum which is ending at N[i]
         * dp[i]    =   (i + 1) * array[i] + 10 * dp[i-1];
         */


        dp[0]   =   array[0]-'0';

        for(int i   =   1;i < array.length ; i++) {
            dp[i]   =  ( ((i + 1) * (array[i]-'0')) % MOD + (10 * dp[i-1]) % MOD + MOD) % MOD;
        }

        out.printArray(ArrayUtils.sumArray(dp) % MOD);


    }


}
