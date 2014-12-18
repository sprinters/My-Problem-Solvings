package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class GasStation {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount =   in.readInt();
        int[] gasAt = IOUtils.readIntArray(in,elementCount);
        int[] costAt    =   IOUtils.readIntArray(in,elementCount);


        int extraTillNow    =   0;
        int totalRequiredGas    =   0;
        int remaining           =   0;
        int stationFromWhichStart =   0;
        for(int i   =   0;i < elementCount ; i++) {

            if(remaining < 0) {
                stationFromWhichStart =   i;
            }

            int totalGas    =   gasAt[i] + extraTillNow;
            int requiredGas =   costAt[i];

            remaining   =   requiredGas-totalGas;

            if(remaining < 0)  {
                totalRequiredGas    +=Math.abs(remaining);
                extraTillNow        =   0;
            } else {
                extraTillNow    =   remaining;
            }

            if(i == elementCount-1){
                out.printLine(totalRequiredGas <= remaining ? stationFromWhichStart:-1);
                return;
            }
        }

    }
}
