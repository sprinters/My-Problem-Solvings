package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class Majority {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int count   =   in.readInt();
        int[] array = IOUtils.readIntArray(in, count);


        int[] tmp   =   new int[3* 1000];
        Arrays.fill(tmp,0);


        for(int i   =   0 ; i < count ; i++) {
            tmp[array[i]+1000]++;
        }


        boolean status  =   false;

        for(int i   =   0;i < 3000 ; i++) {
            if(tmp[i] > (count/2)) {
                out.printLine("YES"+" "+(i-1000));
                return;
            }
        }

        out.printLine("NO");

    }
}
