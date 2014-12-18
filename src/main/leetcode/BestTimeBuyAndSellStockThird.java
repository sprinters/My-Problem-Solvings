package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;
import java.util.Arrays;

public class BestTimeBuyAndSellStockThird {


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);

        int   maxProfit     =   maxProfit(array,in,out);
        out.printLine(maxProfit);
    }

    private int maxProfit(int[] array,InputReader in, OutputWriter out) {


        int[] maxProfitFromStart    =   new int[array.length];
        int[] maxProfitFromEnd      =   new int[array.length];


        Arrays.fill(maxProfitFromEnd,0);
        Arrays.fill(maxProfitFromStart,0);


        int minAt   =   0,maxAt =   array.length-1;

        int maxProfitSoFor  =   Integer.MIN_VALUE;

        // maxProfitFromStart[i] will represent maxProfit till day i.

        for(int i   =   0;i < array.length ; i++) {
            maxProfitSoFor  =   Math.max(maxProfitSoFor,Math.max(0,array[i]-array[minAt]));
            maxProfitFromStart[i]   =   maxProfitSoFor;
            minAt   =   array[minAt] >= array[i] ? i : minAt;
        }

        maxProfitSoFor  =   Integer.MIN_VALUE;
        for(int i   =   array.length-1;i>=0;i--) {
            maxProfitSoFor  =   Math.max(maxProfitSoFor,Math.max(0,array[maxAt]-array[i]));
            maxProfitFromEnd[i] =   maxProfitSoFor;
            maxAt   =   array[i] > array[maxAt] ? i : maxAt;
        }

       // out.printArray(maxProfitFromStart);



        //out.printArray(maxProfitFromEnd);


        int answer  =   0;

        for(int i   =   0;i < array.length-1;i++) {
            answer  =   Math.max(answer,maxProfitFromStart[i]+maxProfitFromEnd[i+1]);
        }
        return Math.max(answer,maxProfitFromStart[array.length-1]);
    }
}
