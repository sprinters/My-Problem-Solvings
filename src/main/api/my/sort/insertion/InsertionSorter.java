package main.api.my.sort.insertion;

import main.api.my.sort.AbstractSorter;
import main.api.my.sort.Employee;


public class InsertionSorter<T> extends AbstractSorter<T> {


    @Override
    public Comparable<T>[] sort(Comparable[] input) {


        if(isSorted(input)) {
            return input;
        }
        /**
         * lets see if input have only one element or zero element,then no need of sorting.
         * just return the input array.
         */
        if(input    ==  null || input.length <= 1) {
            return input;
        }

        /**
         * if input have more than one element.then apply insert sort here.
         * see in insertion sort we assume that {0...j-1} element will be in sorted order already,
         * here we will try to place jth element in proper place.
         *
         * So when we swap element ?
         *   when we found some inversion we have to do one swap.
         *   i.e when found some indexes i and j such that input[i] > input[j];
         */
        for(int j   =   1;j < input.length ; j++) {

            // target element to which we have to place in suitable pos.
            Comparable<T> fromCompare   =   input[j];
            // from which pos we have to go back.
            int i   =   j-1;

            /**
             *
             */
            while(i >= 0){

                // element to which we have to compare from target element
                T toCompare   =   (T)input[i];
                // if the current element is greater than target element
                // then we can say they both are making one inversion.
                // hence we have to do one swap for one inversion.
                if(fromCompare.compareTo(toCompare) < 0) {
                    // swap element
                    input[i+1]=input[i];
                    // move backward by one pos
                    i--;
                    continue;
                }

                break;

            }
            // now input array will contains one free pos.that pos will be the suitable pos for target
            // element.push target element into this pos.
            input[i+1]  =   fromCompare;

        }
        return input;
    }

}
