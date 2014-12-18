package main.api.my.utils.algorithms.mis;

import main.api.my.utils.array.ArrayUtils;

/**
 * * @author sandeepandey
 */
public class BalancePartition {


    public static int[][] getPartitionTable(int[] array,boolean shouldUpdateSum) {

        int sum = (int) ArrayUtils.sumArray(array);
        int[] tmpArray   =   ArrayUtils.shiftArrayByOnePos(array);
        if(shouldUpdateSum) {
            sum/=2;
        }
        return getPartitionTable(tmpArray,tmpArray.length,sum);


    }

    private static int[][] getPartitionTable(int[] array, int rows, int columns) {

        int[][] table   =   new int[rows][columns + 1];

        for(int i   =   0;i < array.length ; i++) {
            for(int j   =   0;j <= columns ; j++) {
                if(i == 0 && j ==   0) {
                    table[i][j] =   1;
                    continue;
                } if(i ==   0 && j !=0) {
                    table[i][j] =   0;
                    continue;
                } if(i !=0 && j ==  0) {
                    table[i][j] =   1;
                    continue;
                }

                if(table[i-1][j] == 1 || (j-array[i] >=0 && table[i-1][j-array[i]] == 1)) {
                    table[i][j] =   1;
                } else {
                    table[i][j] =   0;
                }
            }
        }

        return table;

    }

    public static int getSubsetSum(int[] array,boolean shouldUpdateSum) {
        int[][] table   =   getPartitionTable(array,shouldUpdateSum);
        int maxLimit    =   table[0].length;
        for(int i   =   maxLimit-1 ; i>=0;i--) {
            if(table[table.length-1][i]    ==   1) {
                return  i;
            }
        }

        return -1;
    }


}
