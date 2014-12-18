package main.geeksforgeek.dp.palindromepartitioning;

public abstract class  AbstractPalindromePartitionSolver implements PalindromePartitionSolver {

    public int getMinPalindomeCut(String input) {
        return getMinPalindomeCut(input.toCharArray(),0,input.length());
    }

    protected abstract int getMinPalindomeCut(char[] array, int from, int to);
}
