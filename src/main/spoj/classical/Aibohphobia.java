package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.utils.io.InputReader;

import java.util.Arrays;


public class Aibohphobia {


    private static final int THRESHOLD  =   6001;
    private int first[]              =   new int[THRESHOLD];
    private int second[]             =   new int[THRESHOLD];
    private int diagonal[]           =   new int[THRESHOLD];
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] input    =   in.readString().toCharArray();
        int N           =   input.length;
        Arrays.fill(diagonal, 0);
        for(int i   =   0; i < (N -1); i++) {
            first[i]    =   input[i]    ==  input[i+1] ? 0 : 1;
        }

        //print(first,second,diagonal);
        for(int i   =   3 ; i <= N ; i++) {
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

            // copy second array into first
            // copy first array into diagonal

            for(int k   =   0;k < N ; k++) {
                diagonal[k] =   first[k];
            }


            for(int k   =   0;k < N ; k++) {
                first[k] =   second[k];
            }


        }
        out.printLine(second[0]);

    }
}
