package main.hackerearth.commonfloor;

import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class CricketRating {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int[] array = IOUtils.readIntArray(in, n);
        if(n == 0) {
            out.printLine(0);
            return;
        }
        out.printLine(maxSubArray(array));
    }

    public int maxSubArray(int[] A) {

        int maxSumSeenSoFor    =   A[0];
        int maxSumEndingHere      =   A[0];

        for(int j   =   1; j < A.length ; j++) {

            maxSumEndingHere    =   Math.max(A[j],maxSumEndingHere+A[j]);
            maxSumSeenSoFor     =   Math.max(maxSumSeenSoFor,maxSumEndingHere);

        }
        return maxSumSeenSoFor;
    }
}
