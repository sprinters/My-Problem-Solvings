package main.practice.dp.lis;


import main.api.my.comparators.IntComparator;

abstract class DpBasedSolver  extends LisSolver {

    private int[] lisHelper =   null;
    private IntComparator comparator    =   null;
    public abstract int initValue();
    public int solveLIS(int[] array) {

        lisHelper   =   new int[array.length];
        lisHelper[0]    =   initValue();
        comparator      =   getComparator();
        for(int j   =   1 ; j < array.length ; j++) {

            int maxLisForJ  =   0;
            for(int q   =   0; q < j ; q++) {
                if(comparator.compare(array[j],array[q]) == 1) {
                    if(comparator.compare(lisHelper[q],maxLisForJ) == 1) {
                        maxLisForJ  =   lisHelper[q];
                    }

                }
            }
            lisHelper[j]    =   maxLisForJ + 1;

        }
        return getMax(lisHelper);
    }
}
