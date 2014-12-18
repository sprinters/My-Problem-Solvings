package main.leetcode;

public class BestTimeBuyAndSellStock {

    public static void main(String...s) {
        BestTimeBuyAndSellStock letsRun =   new BestTimeBuyAndSellStock();
        int[] array =   {2,4,1};
        int[] array1    =   {18,19,25,15,20,21,23};
        int[] array2    =   {23,22,21,19,18,17};
        int[] array3        =   {13,14,12,17,16,13,20};
        System.out.println(letsRun.solve(array));
        System.out.println(letsRun.solve(array1));
        System.out.println(letsRun.solve(array2));
        System.out.println(letsRun.solve(array3));
    }

    private int  solve(int... array) {
        return maxProfit(array);

    }

    public int maxProfit(int...array) {


        if(array.length <= 0 ) {
            return 0;
        }

        if(array.length == 1) {
            return 0;
        }

        int maxProfitSoFor  =   0;
        int minAt           =   0;


        for(int i   =   1 ; i < array.length ; i++) {

            // if we sell ith day
            int sellPrice       =   array[i];

            // what is previous minimum buy price
            int optimalBuyPrice =   array[minAt];


            // lets evaluate the profit
            int diff    =   sellPrice-optimalBuyPrice;


            // if you are getting loss
            // better to not buy
            if(diff <= 0) {
                maxProfitSoFor  =   Math.max(0,maxProfitSoFor);

            }
            // if you are getting profit
            //then see whether this profit is better than previous profit
            else {
                maxProfitSoFor  =   Math.max(maxProfitSoFor,diff);
            }

            //this is crucial step
            //whether this price can me min buy price
            minAt   =  array[minAt] > array[i]? i : minAt;
        }


        // return maxProfit
        return maxProfitSoFor;

    }

}
