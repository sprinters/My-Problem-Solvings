package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.number.MyIntegerUtils;
import net.egork.chelper.util.InputReader;

import java.util.Arrays;

public class NoSqaureNumber {


    private static final int upTo   =   100001;
    private static Integer[] primeTable =   null;

    private static int[][] queryTable   =   null;
    static  {
        primeTable  =   null;
        primeTable= MyIntegerUtils.performSuperFastSieve(upTo);
        queryTable  =   new int[10][upTo+1];
        ArrayUtils.fill(queryTable, 0);
        fillTable();

    }

    public  static void fillTable() {

        for(int i = 1; i <=upTo ; i++) {

            boolean result  =   isSquareFree(i);
            if(result) {
                boolean[] array =   getDigitArray(i);

                for(int k   =   0;k < 10; k++) {
                    if(array[k]) {
                        queryTable[k][i] = queryTable[k][i-1] + 1;
                    } else {
                        queryTable[k][i]    =   queryTable[k][i-1];
                    }
                }

            } else {

                for(int k   =   0 ; k < 10 ; k++) {
                    queryTable[k][i]    =   queryTable[k][i-1];
                }
            }
        }

    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {



        int first   =   in.readInt();
        int second  =   in.readInt();
        int digit   =   in.readInt();

        out.printLine(queryTable[digit][second]-queryTable[digit][first-1 <= 0 ? 0 : first-1]);

    }

    public static boolean isSquareFree(int toTest) {

        for(int i   =   0;primeTable[i]*primeTable[i] <= toTest ; i++) {

            Pair<Integer,Long> pair  = null;
       // //IntegerUtils.getDivCountAndRem(toTest,primeTable[i]);

            int exp =   pair.getFirst();
            if(exp > 1) {
                return false;
            }
        }
        return true;
    }


    public static  boolean[] getDigitArray(int num) {

       boolean[] flagArray =   new boolean[10];
       Arrays.fill(flagArray,false);
       if(num == 1) {
           return flagArray;
       }
       while(num != 0) {
            int rem =   num % 10;
            num/=10;
            flagArray[rem]  =   true;
       }
       return flagArray;
    }
}
