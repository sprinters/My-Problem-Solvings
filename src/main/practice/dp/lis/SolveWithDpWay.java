package main.practice.dp.lis;

import main.api.my.comparators.IntComparator;
class SolveWithDpWay extends LISHelper {


    public SolveWithDpWay() {
        abstractLisSolver();
    }
    public void abstractLisSolver() {
        LisSolver solver  =   new DpBasedSolver() {
            @Override
            public int initValue() {
                return 1;
            }

            @Override
            public IntComparator getComparator() {
                return IntComparator.DEFAULT;
            }
        };

        setSuitableLisSolver(solver);

    }
}

