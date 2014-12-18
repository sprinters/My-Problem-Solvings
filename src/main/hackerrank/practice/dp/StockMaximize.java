package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class StockMaximize {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);
        int[] bestPossibility   =   new int[elementCount];
        bestPossibility[elementCount-1] =   array[elementCount-1];
        for(int j   =   elementCount-2;j >=0 ; j--) {
            bestPossibility[j]  =   Math.max(bestPossibility[j+1],array[j+1]);
        }
        long maxProfit  =   0;
        for(int i   =   0;i < elementCount ; i++) {

            if(array[i] < bestPossibility[i])
                maxProfit+=bestPossibility[i]   -   array[i];
        }
        out.printLine(maxProfit);
    }
}
