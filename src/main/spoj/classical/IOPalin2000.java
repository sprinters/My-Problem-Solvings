package main.spoj.classical;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

import java.util.Arrays;

public class IOPalin2000 {

    private static int DEFAULT_THRESHOLD    =   5001;
    private static int first[]              =   new int[DEFAULT_THRESHOLD + 1];
    private static int second[]             =   new int[DEFAULT_THRESHOLD + 1];
    private static int diagonal[]             =   new int[DEFAULT_THRESHOLD + 1];

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N =   in.readInt();
        char[] input    =   in.readString().toCharArray();

        Arrays.fill(diagonal,0,N,0);
        for(int i   =   0; i < (N -1); i++) {
            first[i]    =   input[i]    ==  input[i+1] ? 0 : 1;
        }

        //print(first,second,diagonal);
        for(int i   =   3 ; i <= N ; i++) {
            //Arrays.fill(second,0);
            int fix =   N-i+1;
            for(int j   =   0;j < fix ; j++) {

                int start   =   j;
                int end     =   j + i -1;

                if(input[start] ==  input[end]) {
                    second[start]   =   diagonal[start+1];
                } else {
                    second[start]   =   Math.min(first[start],first[start + 1]) + 1;
                }

            }

            for(int k   =   0;k < N ; k++) {
                diagonal[k] =   first[k];
                first[k]    =   second[k];
            }
        }
        out.printLine(second[0]);


    }

    public void print(int[] first,int[] second,int[] diagonal) {
        printWithMessage(first,"First");
        printWithMessage(second,"Second");
        printWithMessage(diagonal,"Diagonal");

    }

    public void printWithMessage(int[] array,String message) {
        System.out.println(message+":");
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("======================================");
    }
}
