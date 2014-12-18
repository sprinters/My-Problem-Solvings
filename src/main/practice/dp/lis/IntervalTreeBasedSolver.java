package main.practice.dp.lis;


import main.api.my.intervaltree.LongIntervalTree;
import main.api.my.intervaltree.MaxIntervalTree;
import main.api.my.utils.array.ArrayUtils;

abstract class IntervalTreeBasedSolver extends LisSolver {

    private int[] lisArray  =   null;

    public int solveLIS(int[] array) {
        int maxSize = ArrayUtils.maxElement(array);
        LongIntervalTree intervalTree   =   new MaxIntervalTree(maxSize + 1);

        lisArray    =   new int[array.length];
        lisArray[0] =   1;
        intervalTree.update(array[0],array[0],1);

        for(int j   =   1 ; j < array.length ; j++) {
            long maxValue =  intervalTree.query(0,array[j]-1);
            intervalTree.update(array[j], array[j], maxValue + 1);
            lisArray[j] =   (int)(maxValue + 1);
        }
        return getMax(lisArray);

    }

    public int[] getLISArray() {
        return lisArray;
    }
}



