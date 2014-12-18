package main.codeforces.contest.DIV2.Div_239;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;
import main.api.my.utils.mis.misutils.MiscUtils;

import java.util.Arrays;

public class LongPath {

    private static final int MOD    =   1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int roomCount   =   in.readInt();
        int[] back      = IOUtils.readIntArray(in,roomCount);

        MiscUtils.decreaseByOne(back);

        long[] dp    =   new long[roomCount];
        Arrays.fill(dp,0);
       // out.printArray(back);
        dp[0]   =   2;
        for(int j   =   1 ; j < roomCount ; j++) {

            long tmpWays   =    0;
            for(int k   =   back[j] ; k < j ; k++) {
               // out.printLine("k="+k);
                tmpWays+=dp[k];
                if(tmpWays > MOD) {
                    tmpWays-=MOD;
                }
            }
            dp[j]   =   tmpWays+2;
        }

        long answer = ArrayUtils.sumArray(dp);

        out.printLine(answer%MOD);
    }
}
