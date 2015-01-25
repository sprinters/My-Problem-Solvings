package main.hackerearth.openfuture;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class Task2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int maxCapacity = in.readInt();
        int denominationCount = in.readInt();
        int[] array = IOUtils.readIntArray(in,denominationCount);

        int[] helper = new int[maxCapacity + 10];
        Arrays.fill(helper,0);

        for(int i : array) {
            helper[i]++;
        }

        int[] count = new int[maxCapacity + 10];

        for(int i =  1; i <= maxCapacity ; i++) {
            if(helper[i] > 0) {
                count[i] = 1;
                continue;
            }

        }



    }
}
