package main.hackerearth;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class SubsetXOR {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int[] array = IOUtils.readIntArray(in,n) ;


        if(n    == 1) {
            out.printLine(array[0]);
            return;
        }

        out.printLine(0);
    }
}
