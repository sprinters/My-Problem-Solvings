package main.hackerearth;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class WillRickSurviveOrNot {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         = IOUtils.readIntArray(in,elementCount);


        Arrays.sort(array);

        if(array[0] ==  0) {
            out.printLine("Goodbye Rick "+"\n"+0);
            return;
        }

        int start   =   1;

        int step    =   1;
        int pos     =   1;
        int killCount   =   1;
        for(int j   =   start ; j < elementCount ; j++) {


            if( j % 6 ==    0) {
                step++;
            }

            if(array[j]-step <= 0) {
                out.printLine("Goodbye Rick"+"\n"+killCount);
                return;
            }

            step++;

            killCount++;

        }

        out.printLine("Rick now go and save Carl and Judas");
    }
}
