package main.codechef.lunchtime.Apr_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class AndOperation {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int N   =   in.readInt();
        long maxAnd =   0;

        int[] array = IOUtils.readIntArray(in,N);

        for(int from    =   0;from < array.length-1 ; from++) {
            for(int advance     =   from + 1 ; advance < array.length ; advance++) {
                maxAnd  =   Math.max(maxAnd,array[from] & array[advance]);
            }
        }

        out.printLine(maxAnd);

    }
}
