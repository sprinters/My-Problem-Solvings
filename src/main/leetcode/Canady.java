package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class Canady {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);
        out.printLine(candy(array));
    }

    /**
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {

        /**
         * Every child must have one candy.Just assign one candy to each of the child
         */
        int[] dp    =   new int[ratings.length];
        Arrays.fill(dp,1);

        for(int i   =   1;i < ratings.length ; i++) {
            if(ratings[i] > ratings[i-1]) {
                dp[i]   =   dp[i-1]+1;
            }
        }

        for(int i   =   ratings.length-2 ; i>=0 ; i--) {
            if(ratings[i] > ratings[i+1] && dp[i] <= dp[i+1]) {
                dp[i]   =   dp[i+1]+1;
            }
        }

        int total   =   0;
        for(int i   : dp) {
            total+=i;
        }

        return total;

    }
}
