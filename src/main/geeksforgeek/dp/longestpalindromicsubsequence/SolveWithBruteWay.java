package main.geeksforgeek.dp.longestpalindromicsubsequence;
public class SolveWithBruteWay extends LPSSolver {
    @Override
    public int getLongestPalindromicSubsequence(String array, int from, int to) {

        if(array    ==  null || array.length() == 0) {
            return 0;
        }
        if(array.length() == 1) {
            return 1;
        }
        if(from     ==  to) {
            return 1;
        }

        if(array.charAt(from) == array.charAt(to) && ( (from + 1) == to)) {
            return 2;
        }
        if(array.charAt(from)   ==  array.charAt(to)) {
            return getLongestPalindromicSubsequence(array,from + 1,to -1) + 2;
        }
        else {
            return Math.max
            (
                    getLongestPalindromicSubsequence(array,from,to-1),
                    getLongestPalindromicSubsequence(array,from + 1,to)

            )                                                         ;
        }
    }
}
