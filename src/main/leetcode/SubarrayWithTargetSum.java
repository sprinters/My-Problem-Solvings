package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class SubarrayWithTargetSum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);
        int targetSum   =   in.readInt();

        int sumAt   =   array[0];
        int at      =   0;
        for(int i   =   1;i < elementCount ; i++) {

            while(at < (elementCount-1) && sumAt > targetSum) {
                sumAt-=array[at];
                at++;
            }

            if(sumAt    ==  targetSum) {
                out.printLine("YS");
                return;
            }

            sumAt   +=array[i];

        }

    }
}
