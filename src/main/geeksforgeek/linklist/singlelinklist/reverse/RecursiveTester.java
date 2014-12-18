package main.geeksforgeek.linklist.singlelinklist.reverse;

/**
 * Created with IntelliJ IDEA.
 * User: sandeepandey
 * Date: 27/10/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
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
