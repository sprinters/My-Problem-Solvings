package main.hackerearth.yantra;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.math.BigInteger;

public class Battle {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        BigInteger l  =   in.readBigInteger();

        out.printLine(l.multiply(l.subtract(BigInteger.ONE)).
                multiply(l.subtract(BigInteger.valueOf(2))).
                multiply(l.subtract(BigInteger.valueOf(3))).
                divide(BigInteger.valueOf(24)).mod(BigInteger.valueOf(1000000007)));
    }
}
