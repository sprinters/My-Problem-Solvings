package main.spoj.classical;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

public class CheckTheCoprimeness {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long answer =   0;
        long n  =   in.readLong();
        long floorValue = (long) Math.floor((n * 1.0)/2.0);

        while(true) {
            if(gcd(n,floorValue)    ==  1) {
                out.printLine(floorValue);
                return;
            }
            floorValue--;
        }


    }

    public long gcd(long a ,long b) {
        return b == 0 ? a :gcd(b,a%b);
    }
}
