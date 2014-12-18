package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class LargestSubarrayWithEqualZeroAndOne {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        int oneCount    =   0,zeroCount =   0;
        for(int i   =   0;i < elementCount;i++) {

            oneCount    =  oneCount +  array[i]    ==  1 ? 1 : 0;
            zeroCount   =   zeroCount+array[i]  ==  0 ? 1 :0;
        }

        if(oneCount ==  elementCount || zeroCount == elementCount) {
            out.printLine(-1);
            return;
        }

        for(int i   =   0;i < elementCount ; i++) {
            if(array[i] ==  0) {
                array[i]    =   -1;
            }
        }

        int[] dp    =   new int[elementCount];
        Arrays.fill(dp,0);


        for(int i   =   0;i < elementCount ; i++) {
            dp[i]   = array[i] + ( i == 0 ? 0:dp[i-1]);
        }

        // we will find the largest sub array starting from 0th index

        int firstClaim  =   0;

        for(int i   =   0;i < elementCount ; i++) {
            firstClaim  =   dp[i]   ==  0 ? i : firstClaim;
        }


        int maxValue    =   Integer.MIN_VALUE;
        int minValue    =   Integer.MAX_VALUE;

        for(int i   =   1;i < elementCount ; i++) {

            maxValue    =   Math.max(maxValue,dp[i]);
            minValue    =   Math.min(minValue,dp[i]);
        }


        int[] hashes    =   new int[maxValue-minValue+1];

        Arrays.fill(hashes,0);


        int secondClaim =   0;
        for(int i   =   1;i < elementCount ; i++) {
            if(hashes[dp[i]]    ==  0) {
                hashes[dp[i]]   =   i;
            }else {
                secondClaim =   Math.max(secondClaim,elementCount-hashes[dp[i]]+1);
            }
        }

        int answer  =   Math.max(firstClaim,secondClaim);
        out.printLine(answer);



    }
}
