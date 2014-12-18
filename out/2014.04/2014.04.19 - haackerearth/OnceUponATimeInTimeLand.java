package main.hackerearth.indiagacks;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class OnceUponATimeInTimeLand {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int sequenceCount;
        int gap;
        long[] elements ;
        long[] dp;
        sequenceCount   =   in.readInt();
        gap             =   in.readInt();
        elements        =   IOUtils.readLongArray(in,sequenceCount);
        dp              =   new long[sequenceCount+1];
        Arrays.fill(dp,0);


        for(int i   =   0;i < sequenceCount ; i++) {
            if(i == 0) {
                dp[i]   =   Math.max(elements[i],0);
                continue;
            }

            int backPos =   i-gap-1;
            if(backPos < 0) {
                dp[i]   =   Math.max(dp[i-1],elements[i]);
                continue;
            }


            dp[i]   =   Math.max(dp[i-1],dp[backPos]+elements[i]);
        }
        out.printLine(dp[sequenceCount-1]);

    }
}
