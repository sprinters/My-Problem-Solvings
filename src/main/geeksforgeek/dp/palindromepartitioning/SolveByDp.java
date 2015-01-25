package main.geeksforgeek.dp.palindromepartitioning;

public class SolveByDp extends AbstractPalindromePartitionSolver {

    @Override
    protected int getMinPalindomeCut(char[] array, int from, int to) {


        int[][] dp  =   new int[array.length + 1][array.length + 1];
        boolean[][] palindromeHelper    =   new boolean[array.length +1 ][array.length + 1];

        for(int     i   =   0;i < array.length ; i++) {
            dp[i][i]    =   0;
            palindromeHelper[i][i]  =   true;
        }

        for(int l   =   2;l <= array.length ; l++)  {

            for(int fix =   0; fix < (array.length-l + 1) ; fix++) {
                int first   =   fix;
                int second  =   fix + l -1;

                if(l==2) {
                    palindromeHelper[first][second] =   array[first]==array[second];
                } else {
                    palindromeHelper[first][second] =   array[first]    ==  array[second]  &&
                            (palindromeHelper[first + 1][second-1]);
                }
                if(palindromeHelper[first][second]) {
                    dp[first][second]   =   0;
                } else {
                    dp[first][second]   =   Integer.MAX_VALUE;
                    for(int cutAt   =   fix ; cutAt < second ; cutAt ++) {

                        dp[first][second]   =   Math.min(dp[first][second],dp[first][cutAt] + dp[cutAt + 1][second] + 1);
                    }
                }
            }

        }
        return dp[0][array.length-1];

    }
}
