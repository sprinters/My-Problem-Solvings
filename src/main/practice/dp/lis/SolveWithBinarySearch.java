package main.practice.dp.lis;


import main.api.my.comparators.IntComparator;


public class SolveWithBinarySearch extends LISHelper {
    public SolveWithBinarySearch() {
        abstractLisSolver();;
    }

    public void abstractLisSolver() {

        LisSolver solver    =   new BinarySearchBasedSolver() {
            @Override
            public IntComparator getComparator() {

                return IntComparator.DEFAULT;
            }
        }  ;

        setSuitableLisSolver(solver);

    }
}
