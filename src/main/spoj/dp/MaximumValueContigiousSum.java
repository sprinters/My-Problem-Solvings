package main.spoj.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class MaximumValueContigiousSum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);

        int negativeCount   =   0;

        for(int i   =   0;i < array.length ; i++) {
            if(array[i] < 0) {
                negativeCount++;
            }
        }

        // all number are negative
        if(negativeCount    ==  array.length) {
            Pair<Integer,Integer> output    =   ArrayUtils.maxPair(array);
            out.printLine(output.getFirst());
            return;
        }


        int[] optimalSumAt  =   new int[elementCount];
        int[] startAt          =   new int[elementCount];
        int[] endAt         =   new int[elementCount];


        // initialize base cases

        optimalSumAt[0] =   array[0];
        startAt[0]  =   0;
        endAt[0]    =   0;

        for(int at  =   1; at < array.length ; at++) {

            // can we extend old optimal window
            if( ( optimalSumAt[at-1] + array[at] ) > array[at]) {
                optimalSumAt[at]    =   optimalSumAt[at-1] + array[at];
                startAt[at] =   startAt[at-1];
                endAt[at]   =   at;
            }  else {

                optimalSumAt[at]    =   array[at];
                startAt[at] =   at;
                endAt[at]   =   at;
            }
        }

        int bestStart   =   0;
        int bestEnd     =   0;
        int bestSum =   Integer.MIN_VALUE;

        for(int i   =   0;i < elementCount ; i++) {

            if(optimalSumAt[i] > bestSum) {
                bestSum =   optimalSumAt[i];
                bestStart   =   startAt[i];
                bestEnd     =   endAt[i];
            }
        }


        out.printLine(bestSum);

    }
}
