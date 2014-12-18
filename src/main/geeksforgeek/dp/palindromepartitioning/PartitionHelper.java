package main.geeksforgeek.dp.palindromepartitioning;


public abstract class PartitionHelper {
    private PalindromePartitionSolver solver    =   null;

    public PalindromePartitionSolver getSolver() {
        return this.solver;
    }

    public void setSolver(PalindromePartitionSolver solver) {
        this.solver =   solver;
    }

    public int performOperation(String input) {
        return getSolver().getMinPalindomeCut(input);
    }

    public abstract int abstractSolver();

}
