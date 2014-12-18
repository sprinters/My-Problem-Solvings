package main;

import java.util.Arrays;

public class BadSubstring {
    private static  int MAX_LIMIT   =   50;
    private static long[] waysEndingWithA  =   null;
    private static long[] waysNotEndingWithA   =   null;

    static {


        waysEndingWithA =   new long[MAX_LIMIT];
        waysNotEndingWithA  =   new long[MAX_LIMIT];

        Arrays.fill(waysEndingWithA, 0);
        Arrays.fill(waysNotEndingWithA,0);


        // fill base cases

        // number of ways having 1 length ending with a is A itself.
        waysEndingWithA[1]  =   1;

        // number of ways having 1 length not ending with a is 2.
        // because we can put 'b' or 'c'

        waysNotEndingWithA[1]   =   2;

        // for remaining recurrence is as follow
        // waysEndingWithA[k]   =   waysEndingWithA[k-1] + waysNotEndingWithA[k-1]
        // waysNotEndingWithA[k]    =   waysEndingWithA[k-1] + 2 * waysNotEndingWithA[k-1]

        for(int k   =   2;k<=44 ; k++) {
            waysEndingWithA[k]  =   waysEndingWithA[k-1] + waysNotEndingWithA[k-1];
            waysNotEndingWithA[k]   =   2 * waysNotEndingWithA[k-1] + waysEndingWithA[k-1];
        }
    }


    public long howMany(int length) {
        return waysEndingWithA[length] + waysNotEndingWithA[length];
    }
}
