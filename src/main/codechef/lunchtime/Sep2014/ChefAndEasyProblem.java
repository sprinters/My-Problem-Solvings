package main.codechef.lunchtime.Sep2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class ChefAndEasyProblem {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int pileCount   =   in.readInt();
        int[] array     = IOUtils.readIntArray(in,pileCount);

        Arrays.sort(array);

        long maxCollectionByChef    =   0;

        for(int at  =   pileCount-1;at>=0 ; ) {
            maxCollectionByChef += array[at];
            at-=2;
        }


        out.printLine(maxCollectionByChef);


    }
}
