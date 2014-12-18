package main;

import main.api.my.utils.array.ArrayUtils;

public class SumOfPower {
    public int findSum(int[] array) {

        long sum    =   0;

        int[] sumArray  =   new int[array.length];
        sumArray[0] =   array[0];
        for(int j   = 1; j < array.length ; j++)
            sumArray[j] +=sumArray[j-1] + array[j];



        for(int j   =   0;j < array.length ; j++) {

            sum+=ArrayUtils.sumArray(sumArray,j,array.length-1);
            if(j > 0) {
                sum-=sumArray[j-1] * (array.length-j);
            }
        }

        return (int) sum;
    }
}
