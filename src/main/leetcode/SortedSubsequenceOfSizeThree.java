package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class SortedSubsequenceOfSizeThree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);


        int[] left  =   new int[elementCount];
        int[] right =   new int[elementCount];


        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        left[0] =   -1;
        int minAt   =   0;
        int maxAt   =   0;
        for(int i   =   1;i < elementCount ; i++) {

            if(array[i] <= array[minAt]) {
                minAt   =   i;
                left[i] =   -1;
            } else {
                left[i] =   minAt;
            }
        }


        maxAt   =   0;
        right[0]    =   -1;
        for(int i   =   1;i < elementCount ; i++) {

            if(array[i] >= array[maxAt]) {
                maxAt   =   i;
                right[i] =   -1;
            } else {
                right[i] =   maxAt;
            }
        }


    }
}
