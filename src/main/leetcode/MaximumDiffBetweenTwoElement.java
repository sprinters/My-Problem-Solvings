package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class MaximumDiffBetweenTwoElement {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        int maxDiffSoFor    =   Integer.MIN_VALUE;
        int minAt           =   0;

        for(int i   =   0;i < elementCount ; i++) {
            maxDiffSoFor    =   Math.max(maxDiffSoFor,Math.max(0,array[i]-array[minAt]));
            minAt           =   array[i] <= array[minAt] ? i : minAt;
        }
        out.printLine(maxDiffSoFor);
    }
}
