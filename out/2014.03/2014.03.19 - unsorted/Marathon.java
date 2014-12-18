package main.codeforces.contest.DIV2.Div_237;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class Marathon {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        double a   =   in.readDouble();
        double d   =   in.readDouble();

        int    n    =   in.readInt();

        for(int i   =   1 ; i <= n ; i++) {

            double time =   d * i % (4 * a);
            if(time < a) {
                out.printLine(time,0);
            } else if(time < 2 * a) {
                out.printLine(a,time-a);
            } else if(time < 3*a) {
                out.printLine(3*a - time,a);
            } else {
                out.printLine(0,4*a-time);
            }
        }
    }
}
