package main;

import main.api.my.utils.array.ArrayUtils;

import java.util.Arrays;

public class BitStrings {

    private int[][][] lookUp    =   null;
    public int maxStrings(String[] list, int numZeroes, int numOnes) {

        lookUp  =   new int[list.length + 1][numZeroes + 1][numOnes + 1];

        ArrayUtils.fill(lookUp,-1);

        int[] oneAt =   getCountArray(list,'1');
        int[] zeroAt    =   getCountArray(list,'0');

        return solveWithMemo(list.length-1,zeroAt,oneAt,numZeroes,numOnes);
    }


    public int solveWithMemo(int pos,int[] zeroAt,int[] oneAt,int maxZero,int maxOne) {

        if(pos < 0) {
            return -1;
        }

        if(pos  ==  0) {

            if(zeroAt[pos] <= maxZero && oneAt[pos] <= maxOne) {
                lookUp[pos][zeroAt[pos]][oneAt[pos]]    =   Math.max(
                        lookUp[pos][zeroAt[pos]][oneAt[pos]],1
                );
            }

            return lookUp[pos][zeroAt[pos]][oneAt[pos]];
        }

        if(lookUp[pos][zeroAt[pos]][oneAt[pos]] > 0) {
            return lookUp[pos][zeroAt[pos]][oneAt[pos]];
        }


        if(zeroAt[pos] <= maxZero && oneAt[pos] <= maxOne) {
            lookUp[pos][zeroAt[pos]][oneAt[pos]]    =   Math.max(lookUp[pos][zeroAt[pos]][oneAt[pos]],1);
        }

        for(int z   =   0; z<= maxZero ; z++) {
            for(int o   =   0;o <= maxOne ; o++) {

                if(lookUp[pos-1][z][o] > 0) {

                }


            }
        }




                        return 0;


    }

    public int[] getCountArray(String[] list,char toLook) {

        int[] tmp   =   new int[list.length];
        Arrays.fill(tmp,0);

        for(int from    =   0;from < list.length ; from++) {

            String at   =   list[from];

            for(char c : at.toCharArray()) {
                if(c == toLook) {
                    tmp[from]++;
                }
            }

        }

        return tmp;
    }


    public int solveWithDp(String[] list,int numZeroes,int numOnes) {

        int[] oneAt =   getCountArray(list,'1');
        int[] zeroAt    =   getCountArray(list,'0');


        int[][][] dp    =   new int[list.length][numZeroes + 1][numOnes + 1];
        ArrayUtils.fill(dp,-1);

        /**
         * what is dp state here ?
         * f(i,j,k) ---> max number of bit string that can be formed from first i element by using
         * j zeros and k ones.
         *
         *
         */


        if(oneAt[0] <= numOnes && zeroAt[0] <= numZeroes) {
            dp[0][zeroAt[0]][oneAt[0]]  =   Math.max(dp[0][zeroAt[0]][oneAt[0]],1) ;
        }

        for(int i   =   1 ; i < list.length ; i++) {

            int oneCount    =   oneAt[i];
            int zeroCount   =   zeroAt[i];


            if(zeroCount <= numZeroes && oneCount <= numOnes) {
                dp[i][zeroCount][oneCount] =   Math.max(dp[i][zeroCount][oneCount],1) ;
            }

            for(int z   =   0; z <= numZeroes ; z++) {
                for(int o   =   0;o <= numOnes ; o++) {

                    if(dp[i-1][z][o] >= 0) {

                        if(z + zeroCount <= numZeroes && o + oneCount <= numOnes) {

                            dp[i][z][o] =   Math.max(dp[i][z][o],dp[i-1][z][o] + 1);

                        }
                    }
                }
            }
        }


        int best    =   Integer.MIN_VALUE;
        for(int[][] outer : dp) {
            for(int[] inner : outer) {
                best    =   Math.max(best,ArrayUtils.maxElement(inner));
            }
        }


        return best;
    }
}
