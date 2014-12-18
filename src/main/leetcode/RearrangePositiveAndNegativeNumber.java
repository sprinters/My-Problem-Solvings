package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class RearrangePositiveAndNegativeNumber {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int     n   =  in.readInt();
        int[]   array   = IOUtils.readIntArray(in,n);

        array   =   reArrange(array);
        for(int i    : array) {
            out.printLine(i+" ");
        }



    }

    public int[] reArrange(int...array) {

        // we will use here idea of partition from quick sort
        // here our pivot element will be 0
        // lets try to write partition logic


        int start   =   0;
        int beforeWindow    =   start-1;
        int pivot           =   0;
        for(int j   =   start ; j < array.length-1;j++) {

            if(pivot >= array[j]) {

                beforeWindow    =   beforeWindow +1;
                swap(beforeWindow,j,array);
            }

        }
        return array;
    }


    public void swap(int i,int j,int...array) {
        int tmp =   array[i];
        array[i]    =   array[j];
        array[j]    =   tmp;
    }
}
