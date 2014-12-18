package main.hackerrank.practice.dp;

import main.api.my.compress.ArrayBasedCompressor;
import main.api.my.compress.Compressor;
import main.api.my.intervaltree.LongIntervalTree;
import main.api.my.intervaltree.MaxIntervalTree;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class SubsequenceWeighting {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {
        int boundry =   in.readInt();
        long[] sequenceArray = IOUtils.readLongArray(in, boundry);
        long[] wieghtArray   =   IOUtils.readLongArray(in, boundry);
        long[] compressedArray   =   getCompressArray(sequenceArray);
        long[] dp               =   new long[boundry + 3];
        Arrays.fill(dp, 0);
        LongIntervalTree intervalTree   =   new MaxIntervalTree(boundry + 1);
        LongIntervalTree tree           =   new MaxIntervalTree(boundry + 1);
        for(int j   =0 ; j < compressedArray.length ; j++) {
            long tt  =   intervalTree.query(0,(int)compressedArray[j]-1);
            long maxSum =   tree.query(0,(int)compressedArray[j] -1);
            dp[j]   =   maxSum + wieghtArray[j];
            intervalTree.update((int)compressedArray[j],(int)compressedArray[j],tt + 1);
            tree.update((int)compressedArray[j],(int)compressedArray[j],wieghtArray[j] + maxSum);

        }
        long output =   Long.MIN_VALUE;
        for(long i : dp) {
            output = Math.max(output,i) ;
        }
        out.printLine(output);
    }

    private long[] getCompressArray(long[] sequenceArray) {

        Compressor compressor   =   new ArrayBasedCompressor();
        return compressor.compress(sequenceArray);
    }


}
