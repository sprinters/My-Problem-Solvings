package main.geeksforgeek.dp.palindromepartitioning;

public class DpTester extends PartitionHelper {

    String input    =   null;
    public DpTester(String input) {
        this.input  =   input;
    }
    @Override
    public int abstractSolver() {
        PalindromePartitionSolver solver    =   new SolveByDp();
        setSolver(solver);
        return performOperation(input);
    }
}
