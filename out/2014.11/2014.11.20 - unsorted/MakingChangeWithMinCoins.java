package main.spoj.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class MakingChangeWithMinCoins {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array     = IOUtils.readIntArray(in,elementCount);

        int targetSum   =   in.readInt();

        /**
         * dp[i] >> min number of coins needed to make change of amount i
         *
         * @Complexity (elementCount*TargetSum)
         */
        int[] dp    =   new int[targetSum + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        //fill base case
        dp[0]   =   0;
        dp[1]   =   1;

        for(int toChange    =   2;toChange<=targetSum;toChange++) {
            for(int i   =   0;i < array.length ; i++) {

                if(toChange -   array[i] >=0) {
                    dp[toChange]    =   Math.min(dp[toChange],dp[toChange-array[i]] + 1);
                }
            }
        }

        out.printLine(dp[targetSum]);

    }
}
