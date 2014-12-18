package main.hackerrank.special.weekly.year_2014.june.first;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Arrays;

public class AlgorithmicCrush {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int count   =   in.readInt();
        int qtCount =   in.readInt();

        long[] buffer    =   new long[10000009];


        Arrays.fill(buffer,0);
        for(int i   =   0 ; i < qtCount ; i++) {

            int from    =   in.readInt();
            int to      =   in.readInt();
            int toAdd   =   in.readInt();


            buffer[from-1] += toAdd;
            buffer[to]-=toAdd;
        }

        for(int i   =   1;i < buffer.length ; i++) {
            buffer[i]+=buffer[i-1];
        }

        long answer  =   Long.MIN_VALUE;
        for(int j   =   0;j < buffer.length ; j++) {
            answer  =   Math.max(answer,buffer[j]);
        }

        out.printLine(answer);
    }
}
