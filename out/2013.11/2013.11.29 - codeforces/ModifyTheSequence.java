package main.hackerrank.dp;

import main.utils.io.InputReader;
import main.utils.io.OutputWriter;

public class ModifyTheSequence {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N   =   in.readInt();
        int[] array =   IOUtils.readIntArray(in,N);

        LISHelper lisHelper =   new SolveWithBinarySearchInReverse();
        int lisCount        =   lisHelper.performOperation(array);
        out.printLine(array.length-lisCount);

    }
}
