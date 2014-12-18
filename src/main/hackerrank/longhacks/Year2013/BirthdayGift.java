package main.hackerrank.longhacks.Year2013;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.math.BigDecimal;

public class BirthdayGift {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        BigDecimal expectedValue    =   new BigDecimal("0.0");
        int N   =   in.readInt();
        long[] array = IOUtils.readLongArray(in, N);

        for(long i : array) {
            expectedValue   =   expectedValue.add(BigDecimal.valueOf(i).divide(BigDecimal.valueOf(2)));
        }
        out.printLine(expectedValue);
    }
}
