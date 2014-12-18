package main;

import main.api.my.utils.algorithms.mis.BalancePartition;
import main.api.my.utils.array.ArrayUtils;

public class LoadBalancing {


    public int minTime(int[] chunkSizes) {
        chunkSizes =   updateArray(chunkSizes,1024);
        int total   =   (int) ArrayUtils.sumArray(chunkSizes);
        int leftSum = BalancePartition.getSubsetSum(chunkSizes,true);

        return (int) (Math.max(leftSum, total-leftSum) * 1024);
    }



    public int[] updateArray(int[] array,int updateFactor) {

        for(int i   =   0;i < array.length ; i++) {
            array[i]/=updateFactor;
        }
        return array;

    }
}
