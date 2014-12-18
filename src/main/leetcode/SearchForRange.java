package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class SearchForRange {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);
        int target  =   in.readInt();

        out.printLine(searchRange(array,target));

    }

    public int[] searchRange(int[] array, int target) {

        int lowerBound  =   doBinarySearch(array,0,array.length-1,target);
        System.out.println("Lower Bound is::"+lowerBound);

        int upperBound  =   doBinarySearch1(array,0,array.length-1,target);

        System.out.println("Upper Bound is::"+upperBound);

        int[] outputArray   =   new int[2];
        outputArray[0]  =   lowerBound;
        outputArray[1]  =   upperBound;
        return outputArray;


    }

    public int doBinarySearch(int[] array,int from,int to,int target) {

        if(from > to) {
            return -1;
        }

        int mid =   (from + to) >> 1;
        System.out.println("Mid="+mid);
        if(mid >= array.length) {
            return -1;
        }
        if(array[mid]   ==  target) {
            System.out.println("mid="+mid);
            if(mid-1 >=0) {
                if(array[mid-1] < array[mid]) {
                    return mid;
                }
                return doBinarySearch(array,from,mid-1,target);
            }
            return mid;

        } else if(array[mid] > target) {
            return doBinarySearch(array,from,mid-1,target);
        }  else {
            return doBinarySearch(array,mid+1,to,target);
        }

    }


    public int doBinarySearch1(int[] array,int from,int to,int target) {

        if(from > to) {
            return -1;
        }

        int mid =   (from + to) >> 1;

        if(mid >= array.length) {
            return -1;
        }
        if(array[mid]   ==  target) {

            if(mid+1 < array.length) {
                if(array[mid+1] > array[mid]) {
                    return mid;
                }
                return doBinarySearch1(array,mid+1,to,target);
            }
            return mid;

        } else if(array[mid] > target) {
            return doBinarySearch1(array,from,mid-1,target);
        }  else {
            return doBinarySearch1(array,mid+1,to,target);
        }

    }
}
