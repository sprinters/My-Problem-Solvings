package main.hackerrank.special.weekly.year_2014.may.first;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class MaximizingXOR {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int l   =   in.readInt();
        int r   =   in.readInt();

        int maxXOR  =   Integer.MIN_VALUE;


        for(int i   =   l ; i <= r ; i++) {

            for(int j   =   l+1;j<=r ; j++) {
                maxXOR  =   Math.max(maxXOR,i ^ j);
            }

        }

        out.printLine(maxXOR);

    }
}
