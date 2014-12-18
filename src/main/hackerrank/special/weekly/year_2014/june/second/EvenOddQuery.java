package main.hackerrank.special.weekly.year_2014.june.second;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class EvenOddQuery {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int count   =   in.readInt();
        int[] array     =   new int[count+1];
        for(int i   =   0;i < count ; i++) {
            array[i+1]  =   in.readInt();
        }

        int qCount  =   in.readInt();

        for(int i   =   0;i < qCount ; i++) {
            int x   =   in.readInt();
            int y   =   in.readInt();
            /**
             * handle cases where x and y both are equal
             */
            if(x == y) {
                if(array[x] ==  0) {
                    out.printLine("Even");
                } else {
                    out.printLine(array[x]%2    ==  0 ? "Even":"Odd");
                }
            }
            /**
             * handle the case when x is greater than y.
             */
            else if(x > y) {
                out.printLine("Odd");

            }
            /**
             * handle the case when value at x is zero
             */
            else if(array[x] ==  0) {
                out.printLine("Even");
            }
            /**
             * handle the case when array[x] is even and array[x+1] is not zero
             */
            else if(array[x] % 2 ==  0 && (x+1)<= count && array[x+1] != 0) {
                out.printLine("Even");
            }
            /**
             * handle remaining cases
             */
            else {

               out.printLine("Odd");
            }

        }

    }

}
