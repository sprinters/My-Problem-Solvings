package main.codechef.monthly.JULY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class ReachThePoint {


    public void solve(int testNumber, InputReader in, OutputWriter out) {


        long requiredX  =   in.readLong();
        long requiredY  =   in.readLong();


        if( Math.abs(requiredX + requiredY) % 2 == 0) {
            out.printLine(2 * Math.max(Math.abs(requiredX),Math.abs(requiredY)));
        } else {
            out.printLine(1 + 2 * Math.max(Math.abs(requiredX),Math.abs(Math.abs(requiredY)-1)));
        }

    }
}
