package main.geeksforgeek.dp.partition;

import main.api.my.utils.array.ArrayUtils;

public class SolveWithDp extends PartitionSolver {
    @Override
    protected boolean isPartionable(int[] array, int from, int to) {

        int sum    = (int) ArrayUtils.sumArray(array)/2 + 2;
        boolean[][] dp  =   new boolean[sum + 1][to+2];
        for(int i   =   0; i <= to ; i++) {
            dp[0][i]    =   true;
        }

        for(int j   =   1;j <= (sum) ; j++) {
            dp[j][0]    =   false;
        }


        for(int currentSum  =   1; currentSum <= sum ; currentSum ++) {
            for(int fix =   1;fix <= to ; fix++) {
                // suppose we have not choosen this fix element
                boolean first   =   dp[currentSum][fix-1];
                // if we have choosen fix element then
                boolean second  =   (currentSum-array[fix-1]) >=0 ? dp[currentSum-array[fix-1]][fix-1] : false;
                dp[currentSum][fix] =   first || second;

            }
        }
        return dp[sum-1][to];


    }
}
