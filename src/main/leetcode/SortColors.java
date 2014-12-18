package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class SortColors {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        array = sortColors(array);
        out.printArray(array);

    }
    public int[] sortColors(int...array) {

        int from    =   0;
        int to      =   array.length-1;


        // skip all zeros
        while(from < array.length && array[from]  ==  0) {
            from++;
        }

        // skip all 2's from last

        while(to >=0 && array[to]   ==  2) {
            to--;
        }

        //now from will be pointing to some element which will not be zero
        // now to will be pointing to element which will not be pointing to two


        int tmp =   from;
        while(tmp <= to && from<=tmp) {

            if(array[tmp]   ==  0 && tmp > from) {
                swap(array,tmp,from);
                from++;
                continue;
            } else if(array[tmp]    ==  2 ) {
                swap(array,tmp,to);
                to--;
                continue;
            }
            tmp++;
        }

        return array;

    }

    public void swap(int[] array,int i ,int j) {

        int tmp =   array[i];
        array[i]    =   array[j];
        array[j]    =   tmp;

    }
}
