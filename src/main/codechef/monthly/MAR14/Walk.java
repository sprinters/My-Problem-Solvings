package main.codechef.monthly.MAR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class Walk {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int count   =   in.readInt();
        int[] array = IOUtils.readIntArray(in,count);
        int[] remaining =   new int[count+1];
        int result      =   array[0];
        remaining[0]    =   array[0];
        for(int i   =   1  ; i < count ; i++) {

            int leastRequired    =   remaining[i-1]-1;

            if(leastRequired>= array[i]) {
                remaining[i]    =   leastRequired;
            } else {
                remaining[i]    =   array[i];
                result          +=   array[i]-leastRequired;
            }
        }

        out.printLine(result);

    }

}
