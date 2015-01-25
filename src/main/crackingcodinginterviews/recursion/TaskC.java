package main.crackingcodinginterviews.recursion;

import java.util.Arrays;

/**
 * * @author sandeepandey
 */
public class TaskC {

    public static void main(String...s) {
        TaskC taskC =   new TaskC();
        taskC.solve(null);
    }

    private int solve(int[] array) {
        return search(array);
    }

    private int search(int[] array) {
        int targetValue =   89;
        if(array == null) {
            throw new RuntimeException();
        }

        if(array.length == 1) {
            return array[0] ==  targetValue ? 0 : -1;
        }


        return search(array,0,array.length-1,89);
    }

    /**
     * lets analyse problem first.
     * suppose your array is 1 2 3 4 5 6 (sorted !)
     * now suppose you have rotated array unknown array of time,so our array may become like
     * 3 4 5 1 2
     *
     * Yes,we have to search targetElement in this new array.
     * so lets observe the new array.
     *
     * we will notice that now our array can be supposed as a collection of two array.
     *
     * first ---> from ....pivot (nature : increasing order)
     * second ---> pivot---to (nature : increasing order)
     *
     * Hence the problem can be supposed searching of targetValue in two sorted arrays.
     *
     * Ok,lets write down our algorithm in simple term,
     *
     * Input Array [] = {3 ,4 ,5 , 1, 2}
     * targetValue = 1
     *
     * Special Search(array,0,array.length-1,targetValue)
     * Step 1 :
     *
     *      a:) calculate mid .
     *      b:) compare array[mid] to array[from]
     *
     *          if(array[mid] <= array[from])
     *              a:)array is sorted for (from --- mid)
     *              b:) now compare targetElement with array[mid] and array[from]
     *
     *                  if(targetValue <= array[from] && targetValue >= array[mid])
     *                     targetValue is present (from...mid)
     *                     do simple binary search to find targetValue in this range.
     *                  else
     *                      recurse for same problem for the range (mid+1 ... to)
     *
     *     c:) compare array[mid] to array[from]
     *
     *          follow step b.
     *
     *
     *
     *
     * @param array
     * @param from
     * @param to
     * @param targetValue
     * @return
     */
    private int search(int[] array, int from, int to, int targetValue) {

        int mid     =   (from + to) >> 1;

        if(array[mid] == targetValue) {
            return mid;
        }

        if(array[mid] >= array[from]) {

            if(targetValue >= array[from] && targetValue <= array[mid]) {

                int claimIndex  = Arrays.binarySearch(array,0,mid,targetValue);
                //not found
                if(claimIndex == -1) return -1;
                //found
                return claimIndex;
            } else {
                search(array,mid + 1,to,targetValue);
            }
        } else  if(array[mid] <= array[to]) {

            if(targetValue <= array[to] && targetValue >= array[mid]) {

                int claimIndex = Arrays.binarySearch(array,mid + 1,to,targetValue);

                if(claimIndex   ==  -1) {
                    return -1;
                }
                return search(array,mid+1,to,targetValue);

            }
        }
        return -1;

    }
}
