package main.geeksforgeek.dp.longestpalindromicsubsequence;


public abstract class LPSSolver {
    public int getLongestPalindromicSubsequence(String input) {
        return getLongestPalindromicSubsequence(input,0,input.length()-1);
    }

    public abstract int getLongestPalindromicSubsequence(String array, int from, int to);
}
