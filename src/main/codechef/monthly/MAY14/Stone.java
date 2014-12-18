package main.codechef.monthly.MAY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class Stone {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long turnCount      =   in.readInt();
        long[]      first   =   null;
        long[]      second  =   null;
        long[] array        = IOUtils.readLongArray(in, elementCount);

        long firstMaxElement= ArrayUtils.maxElement(array);
        first               =   updateArray(array,firstMaxElement);
        long secondMaxElement   =   ArrayUtils.maxElement(first);

        second          =   updateArray(first,secondMaxElement);

        if(turnCount    ==  0) {
            out.printArray(array);
            return;
        }

        if(turnCount % 2    ==  0) {
            out.printArray(second);
        } else {
            out.printArray(first);
        }



    }

    //-------------------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public long[] updateArray(long[] array,long fromSubtract) {

        long[] tmpArray =   new long[array.length];
        System.arraycopy(array,0,tmpArray,0,array.length);
        for(int i  =    0;i < array.length ; i++) {
            tmpArray[i]    =   fromSubtract-tmpArray[i];
        }

        return tmpArray;
    }
}
