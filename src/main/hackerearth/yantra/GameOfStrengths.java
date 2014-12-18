package main.hackerearth.yantra;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.math.BigInteger;
import java.util.Arrays;

public class GameOfStrengths {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int boxCount    =   in.readInt();
        long[] strengths    = IOUtils.readLongArray(in,boxCount);

        Arrays.sort(strengths);
        long sum = 0;

        for(int i=boxCount-1;i>=0;i--){
            sum += (strengths[i]*(i) - strengths[i]*(boxCount-i-1));
        }

        out.printLine(BigInteger.valueOf(sum).multiply(BigInteger.valueOf(strengths[boxCount-1])).
                mod(BigInteger.valueOf(1000000007)));
    }
}
