package main.codeforces.contest.DIV2.Div_240;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class MashmokhAndTokens {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n      =   in.readInt();
        long a      =   in.readLong();
        long b      =   in.readLong();

        long[] array = IOUtils.readLongArray(in,n);

        for(long i : array) {

            long tmpMul =   (i * a )/ b;

            out.printLine(i-performBinarySearch(tmpMul,0,i,a,b));
        }
    }

    private long performBinarySearch(long tmpMul, long from, long to,long a,long b) {
        if(from > to) {
            return from;
        }

        long mid =   (from + to) >> 1;

        if( (mid * a) / b  < tmpMul) {
            return performBinarySearch(tmpMul, mid+1, to, a, b);
        } else {
            return performBinarySearch(tmpMul, from, mid-1, a, b);
        }
    }
}
