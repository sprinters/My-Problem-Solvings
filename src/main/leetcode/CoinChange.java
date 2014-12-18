package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class CoinChange {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        int target  =   in.readInt();

        /**
         * Idea is again dp problem.
         * We want to know in how many ways target can be achieved from the item
         * present in the array.
         *
         * This problem is same as subset sum problem.
         * we will divide problem in two main catageory.
         *
         * >> ways that involve at least mth coin
         * >> ways that does not involve mth coin
         *
         * so this is recursive formula.
         */

    }
}
