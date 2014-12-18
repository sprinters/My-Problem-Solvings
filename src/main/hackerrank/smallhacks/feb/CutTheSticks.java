package main.hackerrank.smallhacks.feb;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class CutTheSticks {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int[] array = IOUtils.readIntArray(in, n);

        Arrays.sort(array);


        int[] helper    =   new int[1001];
        Arrays.fill(helper,0);
        for(int i : array) {
            helper[i]++;
        }

        int dummy   =   n;

        out.printLine(dummy);
        for(int i : helper) {

            if(i <= 0) {
                continue;
            }
            dummy   =   dummy-i;

            out.printLine(dummy > 0 ? dummy :"");

        }

    }
}
