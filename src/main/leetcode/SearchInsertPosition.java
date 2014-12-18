package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class SearchInsertPosition {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);
        int target  =   in.readInt();

        out.printLine(searchInsert(array,target));

    }

    public int searchInsert(int[] array, int target) {

        return doBinarySearch(array,0,array.length-1,target);

    }

    public int doBinarySearch(int[] array,int from,int to,int target) {
        if(from > to) {
            return from;
        }

        int mid =   (from+to)>>1;
        if(array[mid]   ==  target) {
            return mid;
        }


        else if(target > array[mid]) {
            return doBinarySearch(array, mid+1, to, target);
        } else {
            return doBinarySearch(array,from,mid-1,target);
        }

    }
}
