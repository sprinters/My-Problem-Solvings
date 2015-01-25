package main.geeksforgeek.linklist.singlelinklist.reverse;

/**
 *
 */
public class RecursiveTester extends ReverseHelper {

    public RecursiveTester() {
        super();
        solve();
    }

    private void solve() {
        Reverse letsReverse =   new SolveWithRecursiveWay();
        setRecursiveSolver(letsReverse);
    }
}
