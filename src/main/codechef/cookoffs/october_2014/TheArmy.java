package main.codechef.cookoffs.october_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class TheArmy {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int soldierCount    =   in.readInt();
        int roundCount      =   in.readInt();

        int[] positionAt    = IOUtils.readIntArray(in,roundCount);

        int minPos          =   ArrayUtils.minElement(positionAt);
        int maxPos          =   ArrayUtils.maxElement(positionAt);

        int[] results       =   new int[soldierCount];
        for(int i   =   0;i < soldierCount ; i++) {
            results[i]  =   Math.max(Math.abs(i-minPos),Math.abs(i-maxPos));
        }

        out.printArray(results);



    }
}
