package main.api.my.sort.selection;

import main.api.my.sort.AbstractSorter;


public class SelectionSorter<T> extends AbstractSorter<T> {


    /**
     * how selection sort works ?
     * selection sort stands for suitable selection.it simple find the smallest element present in particular range.
     * it find the first smallest element ,exchange it with first entry.
     * again it find the second smallest element lest exchange with the second entry.
     * in this way selection sort proceed ?
     * so how many comparison will be in worst case ?
     *  total no of comparison= comparison in first selection + comparison in second selection+...
     *          =   n + n-1 + n-2 +....+2+1
     *          = n^2/2
     *
     *  total number of exchange ?
     *          = here is total exchange is O(n)  only.
     */
    @Override
    public Comparable[] sort(Comparable[] input) {

        for(int i   =   0;i < input.length ; i++) {

            int minPos  =   getMinPos(input,i,input.length-1);
           // System.out.println("Collected min pos is for range ("+ i+" ,"+(input.length-1)+")" +"is::"+minPos);
            exchange(input,i,minPos);
        }
        return input;
    }
}
