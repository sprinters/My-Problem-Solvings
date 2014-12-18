package main.codeforces.practice.hashing;

import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import net.egork.chelper.util.InputReader;

public class QueriesForNumberOfPalindrome {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String type =  in.readString();
        int charCount   =   type.length();
        boolean[][] isPalindrome    =   new boolean[charCount+1][charCount+1] ;
        int[][] dp  =   new int[charCount+1][charCount+1];
        ArrayUtils.fill(isPalindrome, false);
        ArrayUtils.fill(dp,0);
        // all one length strings are palindrome
        for(int i   =   0;i < charCount ; i++) {
            isPalindrome[i][i] =    true;
            dp[i][i]    =   1;
        }

        for(int len =   2;len <= charCount;len++) {

            for(int j   =   0;(len + j -1) < charCount;j++) {
                int start   =   j;
                int end     =   len+j-1;
                if(len  ==  2) {
                    isPalindrome[start][end] =   (type.charAt(start)==    type.charAt(end));

                } else {
                    isPalindrome[start][end] =   isPalindrome[start+1][end-1] &&
                            (type.charAt(start)==    type.charAt(end));
                }

                dp[start][end]  =   dp[start][end-1]+dp[start+1][end]-dp[start+1][end-1];
                if(isPalindrome[start][end]){
                    dp[start][end]+=1;
                }
            }

        }

        int queryCount  =   in.readInt();
        for(int i   =   queryCount;i != 0 ; i--) {
            out.printLine(dp[in.readInt()-1][in.readInt()-1]);
        }

    }
}
