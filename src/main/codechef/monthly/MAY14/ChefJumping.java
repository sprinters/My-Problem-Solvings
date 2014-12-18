package main.codechef.monthly.MAY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class ChefJumping {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int[] array =   new int[3];
        array[0]    =   0;
        array[1]    =   1;
        array[2]    =   3;


        long toReach    =   in.readLong();
        long remainingStep   =   toReach % 6;

        for(int i   =   0 ; i < 4 ; i++) {

            if(remainingStep    ==  array[i]) {
                out.printLine("yes");
                return;
            }
        }

        out.printLine("no");
    }
}
