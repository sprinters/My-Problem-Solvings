package main.hackerearth.devfactory;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class LongestIncreasingPath {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int rowCount    =   in.readInt();
        int colCount    =   in.readInt();


        long[][] table   = IOUtils.readLongTable(in,rowCount,colCount);


        long[][] dp      =   new long[rowCount + 10][ colCount + 10];
        ArrayUtils.fill(dp,-1);

        // fill the base cases
        dp[0][0]=1;
        for(int i=1; i<rowCount; i++)
        {
            if(dp[i-1][0]!=-1)
            {
                if(table[i][0]>table[i-1][0])dp[i][0]=dp[i-1][0]+1;
                else dp[i][0]=-1;
            }
        }
        for(int i=1; i<colCount; i++)
        {
            if(dp[0][i-1]!=-1)
            {
                if(table[0][i]>table[0][i-1])dp[0][i]=dp[0][i-1]+1;
                else dp[0][i]=-1;
            }
        }


        for(int row=1;row < rowCount ; row++) {
             for(int col=1;col < colCount ; col++) {

                if(dp[row-1][col] == -1 && dp[row][col-1] == -1) {
                    dp[row][col]    =   -1;
                    continue;
                }

                if(dp[row-1][col] == -1 && dp[row][col-1] != -1) {

                    if(table[row][col] > table[row][col-1]) {
                        dp[row][col]    =   dp[row][col-1] + 1;
                    } else {
                        dp[row][col]    =   -1;
                    }
                } else if(dp[row][col-1]    ==  -1 && dp[row-1][col] != -1) {

                    if(table[row][col] > table[row-1][col]) {
                        dp[row][col]    =   dp[row-1][col] + 1;
                    } else {
                        dp[row][col]    =   -1;
                    }
                } else {

                    if(table[row][col]  > table[row-1][col]) {
                        dp[row][col]    =   dp[row-1][col] + 1;
                    } else {
                        dp[row][col]    =   -1;
                    }

                    if(table[row][col] > table[row][col-1]) {
                        dp[row][col]    =   Math.max(dp[row][col],dp[row][col-1] + 1);
                    }
                }


            }
        }


        long longestPath    =   Long.MIN_VALUE;

        for(int i   =   0;i < rowCount ; i++) {
            for(int j   =   0;j < colCount ; j++) {
                longestPath =   Math.max(longestPath,dp[i][j]);
            }
        }

        out.printLine(longestPath);

    }
}
