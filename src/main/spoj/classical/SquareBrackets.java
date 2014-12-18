package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * This is dynamic programming problem.
 *
 *
 * lets think the problem in this way
 * ways[i][j]   --> number of ways of getting j more [ type of bracket more than ] type of bracket out of
 *                  first i bracket.
 *
 * What are the base cases ?
 *
 * if i=1 and j=1 then ways[1][1]  =   1 ,because there is only way at the start position.just put there [ bracket.
 * if i=1 and j > 0 then ways[1][j] =   0
 * if i>0 and j > 0 then ways[i][j]=ith pos having [ type bracket + ith pos  having ] type bracket.
 *                                 =    ways[i-1][j-1] + ways[i-1][j+1]
 */
public class SquareBrackets {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        Set<Integer> dict   =   new HashSet<Integer>();
        int totalBracketCount   =   in.readInt();
        int openingBracketCount =   in.readInt();
        int[] fixIndices        =   IOUtils.readIntArray(in, openingBracketCount);

        for(int i : fixIndices) {
            dict.add(i);
        }
        totalBracketCount *= 2;
        int[][] dp  =   new int[50 + 1][50+1];
        ArrayUtils.fill(dp, 0);

        /**
         * Wht is dp state here ?
         *
         * dp[i][j] >>
         */
        for(int i   =   1;i <= (totalBracketCount) ;i++) {
            for(int j   =   0;j <=i ; j++) {

                if(i==1) {

                    if(j    ==  1)  {
                        dp[i][j]    =   1;

                    }   else {
                        dp[i][j]    =   0;
                    }
                } else {

                    if(dict.contains(i)) {
                        dp[i][j]    =   (j   ==  0) ? 0 :dp[i-1][j-1];
                    } else {
                        dp[i][j]    =   dp[i-1][j+1] + ( (j ==  0) ? 0 : dp[i-1][j-1]);
                    }
                }
            }
        }

        out.printLine(dp[totalBracketCount][0]);

    }
}
