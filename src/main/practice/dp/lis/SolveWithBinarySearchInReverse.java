package main.practice.dp.lis;


import main.api.my.comparators.IntComparator;

class SolveWithBinarySearchInReverse  extends LISHelper {

    public SolveWithBinarySearchInReverse() {
        abstractLisSolver();;
    }

    public void abstractLisSolver() {

        LisSolver solver    =   new BinarySearchBasedSolver() {
            @Override
            public IntComparator getComparator() {

                return IntComparator.REVERSE;
            }
        }  ;

        setSuitableLisSolver(solver);

    }
}
