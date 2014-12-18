package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class MajorityElement {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        /**
         * This is moore vote algorithm.
         * the algorithm is as follow.
         *
         * declare two variable
         * maxAt    =   0
         * countAt  =   1
         *
         * now start from the second element
         *   if(currentEntry    ==  array[maxAt]) count++;
         *   else count--;
         *   if(count   ==  0) {
         *      assign current element to majority element.
         *   }
         *
         */

        int majorAt =   0;
        int countAt =   0;
        for(int i   =   1;i < elementCount ; i++) {

            if(array[i] ==  array[majorAt]) {
                countAt++;
            } else {
                countAt--;
            }

            if(countAt  ==  0) {
                majorAt =   i;
                countAt =   1;
            }
        }

        out.printLine(array[majorAt]);

    }
}
