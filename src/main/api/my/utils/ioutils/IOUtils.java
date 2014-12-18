package main.api.my.utils.ioutils;


import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.Array;


public class IOUtils {


    public static <U,V> void printPairArray(Pair<U,V>[] array,OutputWriter out) {


        for(Pair<U,V> pair : array) {
            out.printLine(pair);
        }


    }
    public static int[] readIntArray(InputReader in,int size) {
        int[] array =   new int[size];
        for(int j   =   0;j < size ; j++) {
            array[j]    =   in.readInt();
        }
        return array;
    }

    public static long[] readLongArray(InputReader in,int size) {
        long[] array    =   new long[size];
        for(int j   =   0;j < size ; j++) {
            array[j]    =   in.readLong();
        }
        return array;
    }

    public static char[] readCharArray(InputReader in,int size) {
        char[] array    =   new char[size];
        for(int j   =   0; j < size ; j++) {
            array[j]    =   in.readCharacter();
        }
        return array;
    }

    public static String[] readStringArray(InputReader in,int size) {
        String[] array  =   new String[size];
        for(int j   =   0; j < size ; j++) {
            array[j]    =   in.readString();
        }
        return array;
    }

    public static void printCharArray(char[] color,OutputWriter out) {
        for(char c : color) {
            out.print(c+" ");
        }
        out.printLine();

    }

    public static int[][] readIntTable(InputReader in, int rowCount, int colCount) {

        int[][] table   =   new int[rowCount][colCount];

        for(int i   =   0 ; i < rowCount ; i++) {
            table[i]    =   readIntArray(in,colCount);
        }
        return table;
    }


    public static long[][] readLongTable(InputReader in, int rowCount, int colCount) {

        long[][] table   =   new long[rowCount][colCount];

        for(int i   =   0 ; i < rowCount ; i++) {
            table[i]    =   readLongArray(in,colCount);
        }
        return table;
    }

    public static char[][] readCharTable(InputReader in, int rowCount, int colCount) {
        char[][] array  =   new char[rowCount][colCount];

        for(int i   =   0;i < rowCount ; i++) {
            for(int j   =   0;j < colCount ; j++) {
                array[i][j] =   in.readCharacter();
            }
        }
        return array;
    }

    public static<V> void printTable(V[]...array) {

        for(V[] subArray : array) {
            printSingleArray(subArray);
        }

    }


    public static<V> void printSingleArray(V...array) {

        for(int i   =   0;i < array.length ; i++) {
            if(i != (array.length-1)) {
                System.out.print(array[i]+" ");
            } else {
                System.out.println(array[i]);
            }
        }
        System.out.println();
    }


    public static void printIntTable(int[]...array) {

        for(int[] subArray : array) {
            printSingleArray(Array.wrap(subArray));
        }
    }

    public static void printCharTable(char[]...array) {
        for(char[] subArray : array) {
            printSingleArray(subArray);
        }
    }

    public static void printLongTable(long[]...array) {
        for(long[] subArray : array) {
            printSingleArray(subArray);
        }
    }

    public static void printStringTable(String[]...array) {
        printTable(array);
    }




}


