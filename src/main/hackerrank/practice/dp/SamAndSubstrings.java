package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;

public class SamAndSubstrings {

    private static final long MOD   =   1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] array    =   in.readString().toCharArray();
        int[] toWork    =   new int[array.length];

        for(int index=  0; index < toWork.length ; index++) {
            toWork[index]   =   array[index]-'0';
        }


        /**
         * dp[ i ] >> sum of all number that are ending with digit array[i]
         *
         * dp[i] = dp[i-1] * 10 + (i * toWork[i])
         *
         */
        long[] dp   =   new long[array.length];

        dp[0]   =   toWork[0];
        for(int j   =   1 ; j < array.length ; j++) {

            // sum of all number that are ending with array[j]

            long tmpSum =   ( (dp[j-1] * 10) % MOD + ( (toWork[j] * (j+1) ) % MOD  ) + MOD )  % MOD;
            dp[j]   =   tmpSum;
        }

        out.printLine(ArrayUtils.sumArray(dp,MOD) % MOD);
    }
}
