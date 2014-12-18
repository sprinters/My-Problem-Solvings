package main.codechef.cookoffs.april_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class SnapeAndLadder {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        double base    =   in.readInt();
        double leftLine    =   in.readInt();



        double maxResult    =   Math.sqrt(base*base*1.0 + leftLine*leftLine*1.0);
        double minResult     =   Math.sqrt(Math.abs(base*base*1.0 - leftLine*leftLine*1.0));
        out.printLine(minResult+" "+maxResult);
    }
}
