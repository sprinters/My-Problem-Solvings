package main;

import main.api.my.utils.array.ArrayUtils;

public class ThePriceIsRight {
    public int[] howManyReveals(int[] prices) {


        int[] lisAt =   new int[prices.length+1];
        int[] waysAt  =   new int[prices.length+1];

        /**
         * This is dp problem.
         * listAt[i] > lis ending with price[i]
         * waysAt[i] > total number of ways achieving lis at lisAt[i]
         */

        lisAt[0]    =   1;
        waysAt[0]   =   1;


        for(int fix     =   1 ; fix < prices.length ; fix++) {

            int maxLis  =   0;


            for(int back    =   fix-1;back >=0 ; back--) {

                if(prices[fix] > prices[back]) {
                    maxLis  =   Math.max(maxLis,lisAt[back]);
                }
            }

            lisAt[fix]  =   maxLis + 1;

            for(int back    =   fix-1;back>=0 ; back--) {

                if(lisAt[back]  ==  maxLis && prices[fix] > prices[back]) {
                    waysAt[fix]+=waysAt[back];
                }

            }

            if(waysAt[fix]  ==  0) {
                waysAt[fix]+=1;
            }
        }




        int[] answer    =   new int[2];

        int first        = ArrayUtils.maxElement(lisAt);
        int second      =  0;

        for(int i   =   0;i < prices.length ; i++) {
            if(first  ==  lisAt[i]) {
                second  +=waysAt[i];
            }
        }

        answer[0]   =   first;
        answer[1]   =   second;


        return answer;
    }
}
