package main.codechef.monthly.JUNE14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

public class GuessingGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long n  =   in.readInt();
        long m  =   in.readInt();


        long pro    =   n * m;

        long x1 =   n/2;
        long x2 =   n-x1;
        long y1 =   m/2;
        long y2 =   m-y1;

        long tmp    =   (x1 * y2) + (y1 * x2);
        long hcf    = MyIntegerUtils.gcd(tmp,pro);

        out.printLine(tmp/hcf + "/" + pro/hcf);
    }
}
