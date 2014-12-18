package main.codechef.monthly.JULY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class CountSubstrings {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int elementCount    =   in.readInt();
        char[] array        = IOUtils.readCharArray(in,elementCount);
        int previousOneCount    =   0;
        long totalSubstring     =   0;
        for(int i   =   0;i < elementCount ; i++) {

            if(array[i] == '1' ) {
                totalSubstring += previousOneCount + 1;
                previousOneCount++;
            }
        }
        out.printLine(totalSubstring);
    }
}
