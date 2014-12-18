package main.practice.dp.lis;

import main.api.my.comparators.IntComparator;

abstract class LisSolver {

    public abstract int solveLIS(int[] array);
    public abstract IntComparator getComparator();
    public int getMax(int[] array) {

        int maxLen  =   Integer.MIN_VALUE;
        IntComparator intComparator =   getComparator();

        for(int i : array) {
            if(intComparator.compare(i,maxLen) == 1) {
                maxLen  =   i;
            }
        }
        return maxLen;

    }


    public void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
