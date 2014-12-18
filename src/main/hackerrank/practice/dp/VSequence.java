package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;
import main.practice.dp.lis.SolveWithIntervalTree;


public class VSequence {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in, elementCount);
        int[] reverseArray  =   ArrayUtils.reverseArray(array);

        int[] first =   getLisArray(new SolveWithIntervalTree(), reverseArray);
        int[] second    =   getLisArray(new SolveWithIntervalTree(),array);
        first = ArrayUtils.reverseArray(first);
        int result  =   1;
        for(int i   =   0 ; i < elementCount ; i++) {

            if(first[i] > 1 && second[i] > 1) {
                int sum =   first[i] + second[i];
                if(sum > result) {
                    result  =   sum;
                }

            }
        }
        out.printLine(result-1);

    }
    public int[] getLisArray(SolveWithIntervalTree helper,int[] array) {
        helper.performOperation(array);
        return new int[10];

    }

}



