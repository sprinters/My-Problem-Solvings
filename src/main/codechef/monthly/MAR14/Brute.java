package main.codechef.monthly.MAR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class Brute {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long result =   0;

        int count   =   in.readInt();
        int[] array = IOUtils.readIntArray(in,count);

        for(int i   =   0 ; i < count ; i++) {
            for(int j   =    i+1 ; j < count ; j++) {
                if(array[i] * array[j] > array[i]+array[j]) {
                    result++;
                }
            }
        }

        out.printLine(result);
    }
}
