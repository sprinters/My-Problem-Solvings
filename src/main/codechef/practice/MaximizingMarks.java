package main.codechef.practice;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class MaximizingMarks {


    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int qnCount =   in.readInt();
        int allottedTime =   in.readInt();

        int[] marksAt   = IOUtils.readIntArray(in,qnCount);
        int[] allottedTimeAt    =   IOUtils.readIntArray(in,qnCount);


        /**
         * dp1(i,j) >> maximum marks that you can collect from first (i) qn where total time is j and we
         *             are taking ith qn as single valued.
         *
         *             what will be recurrence for this case ?
         *
         *             * This is standard knapsack.
         *             * dp1[i][j] >> max(attempt ith qn,not attempt ith qn)
         *                            max(dp[i-1][j-allottedTimeAt[i]] + marksAt[i],dp[i-1][j])
         *
         *
         * dp2(i,j) >> maximum marks that you can collect from first (i) qn where total time is j and we
         *             are taking ith qn as double valued
         *
         *             here are three main possibility
         *
         *             Pick ith qn as double value
         *             Ignore ith qn
         *             Pick ith qn as single value
         *
         *             We will choose max of above three quantity
         *
         *             max  =   Math.max(dp1[i-1][j-allottedTimeAt[i]] + 2 * marksAt[i]
         *                      ,dp2[i-1][j]
         *                      ,dp2[i-1][j-allottedTimeAt[i]] + marksAt[i]);
         */

        int[][] dp1      =   new int[qnCount+10][allottedTime + 10];
        int[][] dp2      =  new int[qnCount + 10][allottedTime + 10];



        for(int i   =   0; i <= qnCount ; i++) {

            for(int j   =   0;j <= allottedTime ; j++) {

                if(i==0 || j==0) {

                    dp1[i][j]   =   0;
                    dp2[i][j]   =   0;
                    continue;

                }

                else if(allottedTimeAt[i-1] <= j) {

                    dp1[i][j]   =   Math.max(dp1[i-1][j] , dp1[i-1][j-allottedTimeAt[i-1]] + marksAt[i-1]);
                    // pick ith qn as double value

                    dp2[i][j]   =   dp1[i-1][j-allottedTimeAt[i-1]] + 2 * marksAt[i-1];

                    // dont pick ith qn

                    dp2[i][j]   =   Math.max(dp2[i][j],dp2[i-1][j]);

                    // pick ith qn as single value

                    dp2[i][j]   =   Math.max(dp2[i][j],dp2[i-1][j-allottedTimeAt[i-1]] + marksAt[i-1]);


                }
                else {
                    dp1[i][j]   =   dp1[i-1][j];
                    dp2[i][j]   =   dp2[i-1][j];
                }
            }
        }

        out.printLine(dp2[qnCount][allottedTime]);
    }
}
