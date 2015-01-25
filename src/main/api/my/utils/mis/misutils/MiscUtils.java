package main.api.my.utils.mis.misutils;


public class MiscUtils {

    public static final int[] DX4 = {1, 0, -1, 0};
    public static final int[] DY4 = {0, -1, 0, 1};
    public static final int[] DX8 = {1, 1, 1, 0, -1, -1, -1, 0};
    public static final int[] DY8 = {-1, 0, 1, 1, 1, 0, -1, -1};


    public static<T> boolean equals(T first, T second) {
        return first == null && second == null || first != null && first.equals(second);
    }

    public static boolean isValidCell(int row, int column, int rowCount, int columnCount) {
        return row >= 0 && row < rowCount && column >= 0 && column < columnCount;
    }

    private static void decrease(int[] array,int from,int to,int decreaseFactor) {

        for(int i   =   from ; i <=to ; i++) {
            array[i] =   array[i]-decreaseFactor;
        }

    }

    public static void decreaseByOne(int[] array) {
        decrease(array,0,array.length-1,1);
    }

    public static void decreaseByK(int[] array,int decreaseFactor) {
        decrease(array,0,array.length-1,decreaseFactor);
    }

    public static void partialDecrease(int[] array,int from,int to, int decreaseFactor) {
        decrease(array,from,to,decreaseFactor);
    }

    public static void decreaseByOne(int[]...arrays) {

        for(int[] array : arrays) {
             decreaseByOne(array);
        }
    }


    public static long nextPowerOfTwoByLogMethod(long fix) {

        long exponent   = (long) Math.ceil(Math.log(fix));

        return (long) Math.pow(2,exponent);

    }


    public static long nextPowerOfTwoByBitShift(long to) {

        int result  =   1;

        while(result < to) {
            result  =   result << 1;
        }

        return result;

    }

    public static int stepsRequiredToMakeItOne(long to) {

        int step    =   0;

        while(to != 0) {

            to =    to >> 1;
            step++;
        }

        return step;

    }


}
