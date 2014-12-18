package main.codechef.monthly.OCT14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class DevuLandAndDinosaursAndLaddus {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int villageCount    =   in.readInt();
        long[] array         =   IOUtils.readLongArray(in,villageCount);
        long result          =   Math.abs(array[0]);
        long supportingResult       =   array[0];
        for(int at  =   1; at < (villageCount-1) ; at++) {

            supportingResult += array[at];
            result += Math.abs(supportingResult);

        }
        out.printLine(result);
    }
}
