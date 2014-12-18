package main.hackerearth.superprofs;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.math.BigInteger;

public class Blackbox2 {

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        out.printLine(fact(n));
    }

    public static BigInteger fact(int max){
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger result = BigInteger.valueOf(1);
        for(long i = 1; i<=max; i++){
            result  = result.multiply(BigInteger.valueOf(i));

        }
        while (!result.equals(BigInteger.ZERO)) {
            sum = sum.add(result.mod(BigInteger.valueOf(10)));
            result = result.divide(BigInteger.valueOf(10));

        }
        return sum;
    }
}


