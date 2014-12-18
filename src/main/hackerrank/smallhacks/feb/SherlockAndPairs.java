package main.hackerrank.smallhacks.feb;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.math.BigInteger;
import java.util.Arrays;

public class SherlockAndPairs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int[] array = IOUtils.readIntArray(in, n);

        BigInteger answer  =   BigInteger.ZERO;
        Arrays.sort(array);

        int[] compressedValues    = ArrayUtils. getCompressedValues(array) ;

        for(int i : compressedValues) {

            answer  =   answer.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(i-1)));
        }


        out.printLine(answer);

    }
}
