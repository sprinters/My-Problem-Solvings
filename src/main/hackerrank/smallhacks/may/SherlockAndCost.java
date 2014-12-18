package main.hackerrank.smallhacks.may;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class SherlockAndCost {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();

        int[] array         = IOUtils.readIntArray(in,elementCount);

        /**
         * first[i] >> maximum value that we can collect from first i element where Ai = 1
         * so how is recursive formula :
         *    first[i] >> Math.max(first[i-1],second[i-1]+ Math.abs(1-array[i-1]))
         *
         *
         * second[i] >> maximum value that we can collect from the first i element where Ai=B_i
         */
        int[] first         =   new int[array.length + 1];
        int[] second        =   new int[array.length + 1];

        Arrays.fill(first,0);
        Arrays.fill(second,0);

        for(int i   =   1 ; i < elementCount ; i++) {

            first[i]    =   Math.max(first[i-1],second[i-1] + Math.abs(1-array[i-1]));
            second[i]   =   Math.max(first[i-1] + Math.abs(1-array[i]),second[i-1] + Math.abs(array[i]-array[i-1]));

        }

        out.printLine(Math.max(first[elementCount-1],second[elementCount-1]));






    }
}
