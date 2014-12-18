package main.spoj.classical;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class SweetAndSourRock {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        char[] array        = IOUtils.readCharArray(in,elementCount);

        int[][] dp          =   new int[array.length + 1][array.length + 1];


        ArrayUtils.fill(dp,0);

        for(int i   =   0;i < array.length ; i++) {

            dp[i][i]    =   array[i]    ==  '1' ? 1 : 0;

        }

        /**
         *
         * dp(i,j) >> maximum, sweet than can be sold from range i...j
         *
         *
         */

        for(int len = 2; len <= array.length ; len++) {

            for(int j   =   0; j < (array.length-len + 1) ; j++) {

                int startAt   =   j;
                int endAt     =   len + j -1;

                if(len == 2) {

                    if(array[j] == 1) {
                        dp[startAt][endAt]  =   dp[startAt][endAt-1] == 1 ? 2 : 0;
                    } else {
                        dp[startAt][endAt]  =   0;
                    }
                    continue;
                }

                boolean okay    =   isSweetMajor(startAt,endAt,array);

                // check whether complete segment can be considered
                if(okay) {
                    dp[startAt][endAt]  =   (endAt-startAt+1);
                    continue;
                }

                int best    =   Integer.MIN_VALUE;
                for(int cutAt   =   startAt ; cutAt < endAt ; cutAt++) {

                    best    =   Math.max(best,dp[startAt][cutAt] + dp[cutAt+1][endAt]);
                }

                dp[startAt][endAt]  =   best;
            }
        }

        out.printLine(dp[0][array.length-1]);

    }

    /**
     *
     * @param from
     * @param to
     * @param array
     * @return
     */
    public boolean isSweetMajor(int from,int to,char...array) {

        int oneCount    =   0;
        int zeroCount   =   0;

        if(from < 0 || to > array.length) {
             return false;
        }

        for(int j   =   from ; j <= to ; j++) {

            if(array[j] ==  '1') {
                oneCount++;
                continue;
            }
            zeroCount++;

        }


        return oneCount > zeroCount;

    }
}
