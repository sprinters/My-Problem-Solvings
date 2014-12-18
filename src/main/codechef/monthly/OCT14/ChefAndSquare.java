package main.codechef.monthly.OCT14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class ChefAndSquare {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int pointCount  =   in.readInt();
        if(pointCount <= 2) {
            out.printLine(4-pointCount);
            return;
        }
        int[] x         =   new int[pointCount];
        int[] y         =   new int[pointCount];

        for(int i   =   0;i < pointCount ; i++) {
            x[i]    =   in.readInt();
            y[i]    =   in.readInt();
        }


    }
}
