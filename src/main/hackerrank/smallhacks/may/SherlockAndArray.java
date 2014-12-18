package main.hackerrank.smallhacks.may;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class SherlockAndArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[]   array       = IOUtils.readLongArray(in,elementCount);

        long[] f               =   ArrayUtils.createCumulativeSumArray(array);
        long[] r               =   ArrayUtils.createCumulativeSumArrayReverse(array);

        for(int i   =   0 ; i < elementCount ; i++) {

            if(f[i]   ==  r[i]) {
                out.printLine("YES");
                return;
            }

        }
        out.printLine("NO");
    }
}
