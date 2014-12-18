package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

/**
 * @author sandeepandey
 */
public class SearchInSortedArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount  =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);
        int target  =   in.readInt();
        out.printLine(search(array,target));

    }

    public int search(int[] array, int target) {

        if(array    ==  null) {
            return -1;
        }

        if( (array.length) ==  1) {
            //System.out.println("Before returning");
            return array[0] ==  target ? 0:-1;
        }

        int index;
        try {
            index   =   search(array, target, 0, array.length - 1);
        }   catch (Exception e) {
            index=-1;
        }
        return index;
    }

    /**
     * This function will actually process the data and let you know where element may be or may not be.
     * lets discuss some analysis here for this.
     *
     * We can view this problem as ,Complete Array may be considered as a collection of two sorted array
     * both will be in increasing order.
     *
     * now we will do the analysis on the basis of pos of the middle element.
     * if middle element is in upper left array then do simple binary search else recursively calculate
     * the same value again and again.
     *
     * @param array
     * @param target
     * @param from
     * @param to
     * @return
     */
    public int search(int[] array,int target,int from,int to) {

        if(from > to) {
            return -1;
        }

        int mid =   (from + to)>> 1;


            if(array[mid]   ==  target) {

            return mid;
        }

        /**
         * if array[mid] >= array[from]
         * then it means we have sorted position form (from...mid).
         */
        if(array[mid] >= array[from]) {


            /**
             * Okay,target element resides between from..mid and this is sorted array.
             * do simple binary search for this range.
             */
            if(target >= array[from] && target <= array[mid]) {
                int index   = Arrays.binarySearch(array,from,mid+1,target);

                /**
                 * if not found return -1
                 */
                return index < 0 ? -1 : index;

            }

            /**
             * Again instance of same problem..just do recursion here
             */
            return search(array,target,mid+1,to);
        }
        /**
         *
         *
         */
        else if(array[mid] <= array[to]) {


            if(target <= array[to] && target >= array[mid]) {
                int index   =   Arrays.binarySearch(array,mid,to + 1,target);

                return index < 0 ? -1:index;
            }

            return search(array,target,from,mid-1);
        }

        return -1;
    }
}

