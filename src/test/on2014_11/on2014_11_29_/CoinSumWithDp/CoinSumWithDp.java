package test.on2014_11.on2014_11_29_.CoinSumWithDp;



import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * problem is as follow :
 *
 * you are given coin with values v1,v2,v3,....vn and you have to make money
 * C by using these coin.count how many ways you can achieve this.
 * you can assume there is unlimited supply of coins.
 *
 * for example :
 *
 *
 * suppose C=5
 * and coin array is {1,2,3,4,5}
 *
 * possible ways are as follow :
 *
 * {1,1,1,1,1}
 * {1,1,1,2}
 * {1,1,3}
 * {1,4}
 * {5}
 * {1,2,2}
 * {3,2}
 *
 * so as obvious this problem can be solved by using dynamic programming problem.
 *
 * f(i) >> number of ways of converting amount i with coins
 *
 * then recurrence relation will be as follow
 *
 * f(i) =   from k=1 to n-1 {do summation of (f(i-v(k)))}
 *
 * so answer will be at
 *
 * f(C)
 */
public class CoinSumWithDp {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         =   IOUtils.readIntArray(in,elementCount);
        int targetSum       =   in.readInt();
        Set<Pair<Integer,Integer>> lookUp    =   new HashSet<Pair<Integer,Integer>>();

        int[] dp            =   new int[targetSum + 1];
        Arrays.fill(dp,0);


        //fill base cases

        dp[0]   =   1;

        for(int j   =   1;j <= targetSum ; j++) {

            for(int k   =   0;k < array.length ; k++) {

                if ( (j - array[k]) >= 0 && !lookUp.contains(Pair.makePair(j,array[k]))) {
                    dp[j] += dp[j-array[k]];
                    lookUp.add(Pair.makePair(j,array[k]));
                    lookUp.add(Pair.makePair(array[k],j));
                }
            }
        }


        out.printLine(dp[targetSum]);
    }
}
