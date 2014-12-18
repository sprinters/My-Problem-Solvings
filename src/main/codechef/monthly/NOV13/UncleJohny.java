package main.codechef.monthly.NOV13;

import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class UncleJohny {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int N   =   in.readInt();
        int[] array =   IOUtils.readIntArray(in, N);
        int K       =   in.readInt();
        int toCompare   =   array[K-1];

        int count   =   countSmallerElementFromK(array,toCompare);
        out.printLine(count + 1);

    }

    private int countSmallerElementFromK(int[] array, int toCompare) {

        int smallerCount    =   0;
        for(int i : array) {
            if(i < toCompare) {
                smallerCount++;
            }
        }
        return smallerCount;
    }
}
