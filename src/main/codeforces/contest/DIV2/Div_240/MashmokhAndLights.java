package main.codeforces.contest.DIV2.Div_240;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class MashmokhAndLights {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int m   =   in.readInt();


        boolean[] status    =   new boolean[n];
        int[] answer        =   new int[n];


        Arrays.fill(status,true);

        int[] array = IOUtils.readIntArray(in,m);

        for(int i   =   0;i < m ; i++) {

            int start   =   array[i];
            for(int j   =   start-1 ; j <n ; j++) {

                if(status[j]) {
                    status[j]   =   false;
                    answer[j]   =   start;
                }
            }
        }

        out.printArray(answer);
    }
}
