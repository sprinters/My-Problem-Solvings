package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class EggDropingPuzzle {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int floorCount  =   in.readInt();
        int eggCount    =   in.readInt();


        /**
         * See we are going to dp concept here..
         *
         * lets define some dp state
         * suppose we are making trial at xth floor with eggCount n.
         *
         * now there are two possibility ?
         *  1:egg can be break.
         *  2:egg can be survive.
         *
         *  A1: if egg breaked then problem reduce to
         *      (x-1,n-1)
         *  A2 : if egg can survive from this trial
         *      then the problem reduce to
         *      (n,k-x)
         *
         *  here x may varies from 0....n-1
         *
         *  so wht will be our dp state
         *  let dp[i][j] >> min no of trails needed till ith floor with j eggs.
         *
         *
         */

    }
}
