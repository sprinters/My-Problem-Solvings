package main.spoj.classical;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;
import main.api.my.utils.map.Counter;

public class CountingSubsequences {

    private int[] dp    =   null;
    private int seqCount    =   0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        seqCount    =   0;
        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);

        dp      =   new int[elementCount];
        Counter<Integer> myCounter  =   new Counter<Integer>();
        for(int i   =   0;i < elementCount ; i++) {
            dp[i]   =   (i ==    0?0:dp[i-1])+array[i];
        }

        myCounter.add(0);
        for(int i   =   0;i < elementCount ; i++) {
            seqCount    +=myCounter.get(dp[i]-47);
            myCounter.add(dp[i]);

        }

        out.printLine(seqCount);
    }
}
