package main.codechef.monthly.APR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

import java.math.BigInteger;

public class FarmerFeb {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int first   =   in.readInt();
        int second  =   in.readInt();


        int count   =   first + second;
        BigInteger newCount =   BigInteger.valueOf(count);
        if(newCount.isProbablePrime(3)) {
            newCount    =   newCount.add(BigInteger.ONE);
        }
        long nextPrime   =   MyIntegerUtils.nextPrime(newCount.longValue());


        out.printLine(nextPrime-count);
    }
}
