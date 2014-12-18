package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import net.egork.chelper.util.InputReader;


/**
 * The idea of this problem is as follow :
 * Here we are assuming if you are going to solve query like F(n,k),we already know all values of F(n-1,i).
 * where 0<=i <=k.
 *
 * but what is f(n,k) here ?
 *
 * f(n,k) is tha number of permutations of {1...N} having exactly k inversion.
 *
 * then wht are the base cases ?
 *
 * f(n,0)   =   1 for all n > 0
 * f(n,1)   =   n-1 for all n > 0
 *
 * Okay,If F(n,k) has to be calculated then there are n position where Nth term may arrive.
 * For Example :
 *
 * lets calculate F(4,2)
 *
 * here n   =4 and k    =   2.
 * and we already know answer of F(3,i) where 0<= i <=k
 * now lets assume we have straight line containing (n-1) marks.now our problem is that where we can fit Nth(4)
 * value in the straight line. so lets see it
 * F(4,2) = we can fix Nth value at last + we can fix Nth value at (N-1)th pos+ we can fix Nth value at (N-2) pos
 *        = F(3,2)+F(3,1)+F(3,0)
 *        = 2 + 2 + 1
 *        = 5
 *
 *
 * for more clarified version look at this URL.
 *
 * http://www.quora.com/Combinatorics/Let-P-be-a-random-permutation-of-1-to-n-A-pair-i-j-is-called-an-inversion-
 * in-P-if-i-j-but-i-appears-before-j-in-P-How-many-permutation-of-1-to-n-have-exactly-two-inversions
 */
public class Permutaions {

    private static final int rowCount   =    13;
    private static final int colCount   =   rowCount*rowCount;
    private static int[][]  dp          =   null;
    static {
        preprocess();
    }

    private static void preprocess() {

        dp  =   new int[rowCount][colCount];
        ArrayUtils.fill(dp, 0);
        for(int row = 1; row < rowCount ; row++) {
            dp[row][0]  =   1;
            dp[row][1]  =   row-1;
        }

        for(int row =1 ; row < rowCount ; row++) {
            for(int col =   2;col < colCount ; col++) {

                int step    =   row;

                int k   =   col;
                int value   =   0;
                while(step> 0 && k>=0 ) {
                    value+=dp[row-1][k];
                    k--;
                    step--;
                }

           //     System.out.println("Collected value at entry ("+row+","+col+")" +" is "+value);
                dp[row][col]  =   value;
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int     n   =   in.readInt();
        int     k   =   in.readInt();

        out.printLine(dp[n][k]);

    }
}
