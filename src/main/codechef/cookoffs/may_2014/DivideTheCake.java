package main.codechef.cookoffs.may_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class DivideTheCake {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N   =   in.readInt();
        long angle  =   360;
        String output="";

        if(N > 360) {

            out.printLine("n n n");
            return;
        }
        if(angle % N == 0) {
            output+="y ";
        } else {
            output+="n ";
        }


        output+="y ";

        long sum    =   (N * (N-1)) >> 1;
        if(sum > 360) {
            output+="n";
        } else if( (360-sum) > N) {
            output+="y";
        } else {
            output+="n";
        }
        out.printLine(output);

    }
}
