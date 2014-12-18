package main.geeksforgeek.dp.longestpalindromicsubsequence;

public class BruteTester extends LpsHelper {


    @Override
    public int abstractSolver(String input) {
        LPSSolver solver    =   new SolveWithBruteWay();
        setSolver(solver);
        return performOperation(input);

    }
}
