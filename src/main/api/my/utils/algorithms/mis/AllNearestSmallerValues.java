package main.api.my.utils.algorithms.mis;

import java.util.Arrays;
import java.util.Stack;

/**
 * * @author sandeepandey
 */
public class AllNearestSmallerValues {

    /**
     * This method will not return exact value..rather it will return indices of nearest smaller value.
     * @param array
     * @return
     */
    public static int[] computeAllNearestSmallerValues(int...array) {
        return computeAllNearestSmallerValues(array,0,array.length-1);
    }

    /**
     *
     * lets describe how this algorithm will proceed ..
     * okay..we will maintain one stack here...and how we proceed ?
     *
     * @param array
     * @param from
     * @param to
     * @return
     */
    public static int[] computeAllNearestSmallerValues(int[] array,int from,int to) {
        int[] output    =   new int[to-from+1];
        Arrays.fill(output,0);

        // lets define the stack which will maintain the information
        // we will maintain in decreasing to increasing order.
        Stack<Integer> helperStack  =   new Stack<Integer>();

        for(int i   =   from ; i    <= to ; i++) {

            /**
             * start popping out element untill stack top remain greater than current element
             * because these element may not be part of current element..and for further element
             * current element may be value which claim the nearest smaller value .
             */
            while(!helperStack.isEmpty() && array[helperStack.peek()] > array[i]) {
                helperStack.pop();
            }

            // now if stack is not empty
            // so stack top element will be less than current element.so this stack top
            // element will be nearest smaller value for the current element.
            output[i]   =   helperStack.isEmpty()?-1:helperStack.peek();

            /**
             * Add current element into the stack for further elements.
             */
            helperStack.push(i);
        }

        return output;
    }

    public static void main(String...s) {
        AllNearestSmallerValues testIt  =   new AllNearestSmallerValues();
        int[] array =   new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        computeAllNearestSmallerValues(array);
    }
}
