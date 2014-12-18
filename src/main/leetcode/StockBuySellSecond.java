package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class StockBuySellSecond {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         =   IOUtils.readIntArray(in,elementCount);

        out.printLine(maxProfit(array));

    }

        public int maxProfit(int[] prices) {

            int minAt   =   -1;
            int maxAt   =   -1;

            int start   =   0;

            int maxProfit   =   0;


            while(start < prices.length) {

                // fina local minimum
                while(start < prices.length-1 && prices[start] > prices[start+1]) {
                  start++;
                }


                // we have reached till end
                if(start    ==  prices.length-1) {
                    break;
                }

                //otherwise store index of min Element

                minAt       =   start;

                // find local maximum now after start

                start   =   start +1;
                while(start < prices.length &&  prices[start] >= prices[start-1] ) {
                    start ++;
                }

                maxAt   =   start-1;

                maxProfit   +=  prices[maxAt]-prices[minAt];

            }
            return maxProfit;
        }
}
