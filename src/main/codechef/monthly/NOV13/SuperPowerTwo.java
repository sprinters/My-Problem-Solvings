package main.codechef.monthly.NOV13;

import main.api.my.io.OutputWriter;
import main.utils.io.InputReader;

import java.math.BigInteger;

public class SuperPowerTwo {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        BigInteger b    =   in.readBigInteger();
        BigInteger val  =   new BigInteger(b.toString(2));
        BigInteger mod= BigInteger.valueOf(1000000007) ;
        BigInteger subVal   =   BigInteger.valueOf(2).modPow(val,mod);
        out.printLine(subVal.modPow(BigInteger.valueOf(2),mod));
    }
}
