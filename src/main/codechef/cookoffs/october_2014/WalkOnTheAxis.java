package main.codechef.cookoffs.october_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class WalkOnTheAxis {

    private static long[] answers   =   null;

    static {

        answers =   new long[1000001];

        // fill base cases
        // very nice solution
        answers[0]  =   0;
        answers[1]  =   2;

        for(int j   =   2 ; j<= 100000 ; j++)
            answers[j] = 2*j + 1 + answers[j-2];
    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int lightCount  =   in.readInt();
        out.printLine(answers[lightCount]);


    }
}
