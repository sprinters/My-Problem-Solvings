package main.codechef.monthly.JUNE14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class ChefAndSubarray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         =   IOUtils.readIntArray(in,elementCount);

        int previousZeroAt  =   -1;
        int maxLen          =    -1;

        for(int i   =   0;i < elementCount;i++) {

            if(array[i] ==  0)  {
                maxLen  =   Math.max(maxLen,i-previousZeroAt-1);
                previousZeroAt  =   i;
            }
        }

        if(maxLen == -1) {
            maxLen  =   array.length;
        }

        out.printLine(maxLen);

    }
}
