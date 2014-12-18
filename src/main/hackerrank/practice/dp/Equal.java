package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class Equal {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int elementCount    =   in.readInt();
        long[] array         = IOUtils.readLongArray(in, elementCount);

        Pair<Long,Long> minPair   =   ArrayUtils.minPair(array);

        long result  =   Integer.MAX_VALUE;

        long minValue    =   minPair.getFirst();

        long save   =   minValue;

        for(int i   =   0;i <= 5 ; i++) {

            result  =   Math.min(result,go(array,save-i)) ;
        }

        out.printLine(result);


    }

    public long go(long[] array,long toSubtract) {

        long[] tmpArray   = Arrays.copyOf(array,array.length);
        for(int i   =   0;i < array.length ; i++) {
            tmpArray[i]-=toSubtract;
            tmpArray[i] =   Math.abs(tmpArray[i]);

        }

        long minOperation    =   0;

        for(int i   =   0;i < tmpArray.length ; i++) {
            long e=tmpArray[i];
            long x = e % 5;
            long y = e/5;
            minOperation += y;
            y =  x / 2;
            x = x % 2;
            minOperation += y;
            minOperation += x;
        }
        return minOperation;

    }
}
