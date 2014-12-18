package main.hackerrank.special.weekly.year_2014.june.third;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class ConsecutiveSubsequences {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int count   =   in.readInt();
        int modulo  =   in.readInt();

        int[] oldArray = IOUtils.readIntArray(in,count);
        int[] array       = ArrayUtils.shiftArrayByOnePos(oldArray);
        long[][] dp  =   new long[2][modulo + 1];


        //out.printArray(array);


        long result  =   0;
        int currentRow  =   1;


        // fill base case ?
        dp[0][array[1] % modulo]    =   1;

        result  =   dp[0][0];
        for(int at = 2 ; at < array.length ; at++) {

            Arrays.fill(dp[currentRow],0);
            int previousRow =   1-currentRow;
            for(int remainder   =   0; remainder < modulo ; remainder++) {
                dp[currentRow][(remainder + array[at] ) % modulo]   =   dp[previousRow][ remainder ];
            }

            dp[currentRow][array[at] % modulo]+=1;
            result+=dp[currentRow][0];
            currentRow  =   1-currentRow;
        }

        out.printLine(result);

    }
}
