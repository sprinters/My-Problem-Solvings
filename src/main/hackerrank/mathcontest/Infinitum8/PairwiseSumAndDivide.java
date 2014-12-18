package main.hackerrank.mathcontest.Infinitum8;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class PairwiseSumAndDivide {

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        long[] array    = IOUtils.readLongArray(in,n);


        long sum    =   0;

        for(int i   =   0;i < n ; i++) {

            sum+=Math.ceil(1/array[i]);
        }
        out.printLine(sum * (n-1));
    }
}
