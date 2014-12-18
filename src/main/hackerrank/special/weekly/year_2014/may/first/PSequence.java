package main.hackerrank.special.weekly.year_2014.may.first;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Arrays;

public class PSequence {


    private static long MOD =   1000000007;


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        /**
         * F(I,J) >> number of p sequence from the first i element where last element
         *           is less than <= (J)
         *
         * G(I,J) >> number of P sequence from the first i element where last element
         *           is less than <= (P/J)
         *
         *
         *  BASE CASE:
         *
         *     F(1,j) = j
         *     G(1,j) = P/j
         *
         *  RECURSIVE STEP:
         *
         *      f(i,j) >> f(i,j-1) + g(i-1,j)
         *
         *      g(i,j) >> g(i,j+1) + (P/j - P/j+1) * f(i-1,j)
         *
         */

        int n  =   in.readInt();
        int p  =   in.readInt();

        int pSqrt       = (int) Math.sqrt(p * 1.0) ;
        int maxSqrt     =  pSqrt   + 5;

        long[] first =   new long[maxSqrt];
        long[] second    =   new long[maxSqrt];
        long[] third     =   new long[maxSqrt];
        long[] fourth    =   new long[maxSqrt];

        Arrays.fill(first,0);
        Arrays.fill(second,0);
        Arrays.fill(third,0);
        Arrays.fill(fourth,0);


        for(int i   =   1 ; i <= pSqrt ; i++) {

            first[i]    =   i;
            second[i]    =   p/i;
        }


        for(int i   =   2;i <= n ; i++) {


            third[1]    =   second[1];

            for(int j  =    2 ; j < maxSqrt ; j++) {

                third[j]    =   (third[j-1] + second[j] + MOD ) % MOD ;
            }

            fourth[pSqrt + 1]   =  third[p/(pSqrt + 1)];

            for(int j   =   pSqrt;  j > 0 ; j--) {
                fourth[j]   =   (fourth[j+1] +  ((p/j - p/(j+1)) * 1l * first[j]) % MOD + MOD) % MOD;
            }

            System.arraycopy(third,0,first,0,first.length);
            System.arraycopy(fourth,0,second,0,second.length);

            Arrays.fill(third,0);
            Arrays.fill(fourth,0);

        }

        out.printLine(second[1]);
    }
}
