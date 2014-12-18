package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class PartitionProblem {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount       =    in.readInt();
        int[] array            = IOUtils.readIntArray(in,elementCount);

        int sum = (int) ((ArrayUtils.sumArray(array) >> 1) + 1);

        boolean[][] dp  =   new boolean[sum + 1][elementCount+1];
        /**
         * we are going to write dp solution here.dp[i][j] will be true if and only if
         * we can obtain of sum i from any subset of array[0],array[1]...array[j-1].
         * otherwise false.
         *
         * So wht will be the base cases ?
         * first base case :
         *
         * could you obtain sum as 0 by using i...j indices,yes we can always get sum equal
         * to zero by not using any element.
         *
         * second base case :
         *
         * if there is only one element..then whether we can obtain any sum..we can not
         * so just fill dp[i][0]=0 when i > 0.
         *
         */

         // fill first test case ?

        for(int i   =   0;i <= elementCount ; i++) {
            dp[0][i]    =   true;
        }

        // fill second base case ?

        for(int i   =   1;i<=sum ; i++) {
            dp[i][0]    =   false;
        }


        for(int localSum    =   1;localSum<=sum ; localSum++) {

            for(int i   =   1;i <=elementCount ; i++) {

                dp[localSum][i] =   dp[localSum][i-1] || dp[localSum-array[i]][i-1];
            }

        }
    }
}
