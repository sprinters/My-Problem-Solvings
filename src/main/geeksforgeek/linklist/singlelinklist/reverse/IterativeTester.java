package main.geeksforgeek.linklist.singlelinklist.reverse;

public class IterativeTester extends ReverseHelper {
    public IterativeTester() {
        super();
        solve();
    }

    private void solve() {
        Reverse letsReverse =   new SolveWithIterativeWay();
        setRecursiveSolver(letsReverse);
    }
}
