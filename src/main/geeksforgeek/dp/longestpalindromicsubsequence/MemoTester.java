package main.geeksforgeek.dp.longestpalindromicsubsequence;


public class MemoTester extends LpsHelper {

    @Override
    public int abstractSolver(String input) {
        LPSSolver solver    =   new SolveWithMemorization();
        setSolver(solver);
        return performOperation(input);
    }
}
