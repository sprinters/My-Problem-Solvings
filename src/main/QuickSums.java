package main;

import main.api.my.utils.array.ArrayUtils;
public class QuickSums {

    private static int[][][] dp =   new int[1<<4][1<<4][1<<7];
    public int minSums(String numbers, int sum) {

        char[] numArray =   numbers.toCharArray();
        int count   =   numbers.length();


        ArrayUtils.fill(dp,-1);

        /**
         * Whats is dp state here ?
         * dp[i][j][k] ---> minimum number of '+' required between i--j to achieve sum k.
         *
         * dp[i][j][k] = -1 if sum k cant be formed between i--j
         *
         * wht is recurrence here ?
         * f(i,j,k)--- for (int p   =   i ; p < j ; p++)
         */

        for(int i   =   0;i < count ; i++) {
            for(int j   =   i;j < count ; j++)  {
                dp[i][j][toNumber(numArray,i,j)]   =   0;
            }
        }


        for(int i   =   2;i <= count ;  i++) {
            for(int j   =   0;j < (count-i+1) ; j++) {
                for(int targetSum   =   0   ; targetSum <= sum ; targetSum++) {
                    int from        =   j;
                    int end         =   i+j-1;
                    for(int cutAt   =   from ; cutAt < end ; cutAt++) {

                        for(int partialSum  =   0;partialSum <= targetSum ; partialSum++) {

                            if(dp[from][cutAt][partialSum] == -1 || dp[cutAt + 1][end][targetSum-partialSum] == -1 )  {
                                continue;
                            }

                            if(dp[from][end][targetSum] == -1) {
                                dp[from][end][targetSum]    =   Integer.MAX_VALUE;
                            }

                            dp[from][end][targetSum]    =   Math.min(dp[from][end][targetSum],
                                    dp[from][cutAt][partialSum] + dp[cutAt + 1][end][targetSum-partialSum] + 1);
                        }
                    }

                }
            }
        }
        return dp[0][count-1][sum];
    }


    private long toNumber(String input) {

        return toNumber(input.toCharArray(),0,input.length()-1);

    }

    private int toNumber(char[] array,int start,int end) {

        int res =   0;
        for(int i   =   start;i<=end ; i++) {
            res=    res*10+array[i]-'0';
            res     =   Math.min(res,111);
        }
        return res;
    }
}
