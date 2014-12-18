package main.codechef.practice;

import main.api.my.io.OutputWriter;
import main.utils.io.InputReader;

public class CountPalindromes {
    private static final int MOD    =   1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String type =   in.readString();
        int lenCount  = type.length();
        boolean[][] isPalindrome    =   new boolean[lenCount][lenCount];

        for(int i   =   0;i < lenCount ; i++) {
            isPalindrome[i][i] =    true;

        }

        for(int len =   2;len <= lenCount;len++) {

            for(int j   =   0;(len + j -1) < lenCount;j++) {
                int start   =   j;
                int end     =   len+j-1;
                if(len  ==  2) {
                    isPalindrome[start][end] =   (type.charAt(start)==    type.charAt(end));

                } else {
                    isPalindrome[start][end] =   isPalindrome[start+1][end-1] &&
                            (type.charAt(start)==    type.charAt(end));
                }

            }

        }
        int[] dp    =   new int[lenCount+1];
        dp[0]=1;
        for(int len=1;len<=lenCount;len++) {
            for(int j   =   0;j < len ; j++) {

            }
        }

    }
}
