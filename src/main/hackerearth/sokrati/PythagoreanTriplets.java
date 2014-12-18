package main.hackerearth.sokrati;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class PythagoreanTriplets {


    private static long[]   squares =   null;
    private static long[]   count   =   null;


    static {

        squares =   new long[9501];
        count   =   new long[9501];


        for(int i   =   1;i<=9500;i++) {
            squares[i]  =   i * i;
        }


        for(int c = 1;c <= 9500 ; c++) {

            int from    =   1;
            int to      =   c;

            int tcount   =   0;


            while(from < to) {

                if(squares[from] + squares[to] == squares[c]) {
                    tcount++;
                    from++;
                    to--;
                } else if(squares[from] + squares[to] > squares[c]) {
                    to--;
                }  else {
                    from++;
                }

            }


            count[c]    =   count[c-1]+tcount;

        }



    }



    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        out.printLine(count[n]);

    }



}
