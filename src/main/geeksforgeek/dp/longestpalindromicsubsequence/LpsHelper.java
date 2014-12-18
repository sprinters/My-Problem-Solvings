package main.geeksforgeek.dp.longestpalindromicsubsequence;


public abstract class LpsHelper {
    private LPSSolver solver   =   null;

    public LPSSolver getSolver() {
        return this.solver;
    }
    public void setSolver(LPSSolver solver) {
        this.solver =   solver;
    }

    public int performOperation(String input) {
        return getSolver().getLongestPalindromicSubsequence(input);
    }

    public abstract int abstractSolver(String input) ;
}
