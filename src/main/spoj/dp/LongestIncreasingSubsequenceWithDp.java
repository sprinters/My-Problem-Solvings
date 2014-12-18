package main.spoj.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class LongestIncreasingSubsequenceWithDp {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        int[] dp    =   new int[elementCount+1];
        int[] pos   =   new int[elementCount + 1];

        dp[0]   =   1;
        pos[0]  =   -1;
        for(int j   =   1;j < elementCount ; j++) {

            for(int i   =   0;i < j ; i++) {

                if(array[i] < array[j] && (dp[j] < dp[i] + 1)) {
                    dp[j]   =   dp[i] + 1;
                    pos[j]  =   i;
                }
            }
        }

        Pair<Integer,Integer> optimalPair   = ArrayUtils.maxPair(dp);

        int maxElement  =   optimalPair.getFirst();
        int maxIndex    =   optimalPair.getSecond();

        out.printLine(maxElement);
        String lis  =   printLis(array,pos,maxIndex," "+array[maxIndex]);
        out.printLine(lis);
    }

    private String printLis(int[] array,int[] pos,int toStart,String output) {

        if(pos[toStart] == -1) {
            return output;
        }
        return printLis(array,pos,pos[toStart],array[pos[toStart]]+" "+output);
    }
}
