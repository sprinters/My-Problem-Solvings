package main.hackerearth.druva;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array    = IOUtils.readLongArray(in,elementCount);
        int queryCount  =   in.readInt();
        long[] qtyArray =   IOUtils.readLongArray(in,queryCount);

        for(long queryAt : qtyArray) {

            for(int i   =   0;i < elementCount ; i++) {
                if(array[i] > queryAt) {
                    array[i]-=1;
                }
            }

        }

        out.printArray(array);
    }
}
