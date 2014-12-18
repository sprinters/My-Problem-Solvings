package main.practice.dp.lis;


import main.api.my.comparators.IntComparator;

public class SolveWithIntervalTree extends LISHelper {

    //--------------------------------------------------------------------
    public SolveWithIntervalTree() {
        abstractLisSolver();
    }

    //--------------------------------------------------------------------
    public void abstractLisSolver() {

        LisSolver solver    =   new IntervalTreeBasedSolver() {
            @Override
            public IntComparator getComparator() {
                return IntComparator.DEFAULT;
            }
         } ;
        setSuitableLisSolver(solver);
    }

    //---------------------------------------------------------------------
}

