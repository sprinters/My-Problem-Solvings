package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;

public class MaximumProductCutting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] dp    =   ArrayUtils.generateOrder(elementCount+1);

        dp[1]   =   0;
        /**
         * This is dp problem.lets suppose we have dp[i] >> optimal result you can obtain
         * for length i.
         * dp[i+1]  =   MAX(dp[k] * dp[i+1-k]) for 0<= k < i+1
         */
        for(int len =   2;len<=elementCount ; len++) {

            for(int i   =   0;i < len ; i++) {
                dp[i]   =   Math.max(dp[i],dp[i] * dp[len-i]);
            }
        }

    }
}
