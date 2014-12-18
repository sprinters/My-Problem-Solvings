package main.hackerearth.procto;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.math.BigInteger;

public class DiceRolls {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int m   =   in.readInt();

        BigInteger answer   =   BigInteger.valueOf(2).pow(n+1).subtract(BigInteger.valueOf(2));
        answer  =   answer.subtract(BigInteger.valueOf(2).pow(m+1).subtract(BigInteger.valueOf(2)));
        out.printLine(answer+".00");
    }
}
