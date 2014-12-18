package main.codechef.monthly.MAR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class LittleChefAndNumbers {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);

        // make sure here potential count are zero,one,two

        int[] oneCount  =   new int[elementCount + 1];
        int[] zeroCount =   new int[elementCount + 1];
        int[] twoCount  =   new int[elementCount + 1];

        Arrays.fill(oneCount,0);
        Arrays.fill(zeroCount,0);
        Arrays.fill(twoCount,0);


        zeroCount[0]    =   array[0] == 0? 1 :0;
        oneCount[0]     =   array[0] == 1? 1 : 0;
        twoCount[0]     =   array[0] == 2? 1 : 0;

        for(int i   =   1;i < elementCount ; i++) {
            zeroCount[i]    =   zeroCount[i-1] + (array[i] == 0 ? 1: 0);
        }

        for(int i   =   1;i < elementCount ; i++) {
            oneCount[i]    =   oneCount[i-1] + (array[i] == 1 ? 1: 0);
        }

        for(int i   =   1;i < elementCount ; i++) {
            twoCount[i]    =   twoCount[i-1] + (array[i] == 2 ? 1: 0);
        }
        long result =   0;
        for(int v   =   0;v < elementCount ; v++ ) {

            if(array[v] ==1 || array[v] == 0) {
               continue;
            }

            result  =   result + (elementCount-1-v);
            result-=    zeroCount[elementCount-1]-zeroCount[v];
            result-=    oneCount[elementCount-1]-oneCount[v];
            if(array[v] == 2) {
                result-=twoCount[elementCount-1]-twoCount[v];
            }
        }

        out.printLine(result);
    }
}
