package main.codechef.cookoffs.may_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class UpsAndDowns {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array         = IOUtils.readLongArray(in,elementCount);

        Arrays.sort(array);
        if(elementCount % 2 == 1) {

            for(int j   =   1;j < elementCount-1 ; j+=2) {

                long tmp =   array[j];
                array[j]    =   array[j+1];
                array[j+1]  =   tmp;
            }

        } else {
            for(int j   =   1;j < elementCount-2 ; j+=2) {

                long tmp =   array[j];
                array[j]    =   array[j+1];
                array[j+1]  =   tmp;
            }

        }


        out.printArray(array);
    }
}
