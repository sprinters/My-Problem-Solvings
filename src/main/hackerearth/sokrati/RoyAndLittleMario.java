package main.hackerearth.sokrati;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class RoyAndLittleMario {

    private static  long[] answer  =   new long[1000010];
    private static int MOD  =   1000000007;
    static {
        answer[0]   =1;
        answer[1]   =   1;
        answer[2]   =   2;

        for(int j   =   3 ; j <=1000000 ; j++) {
            answer[j]   =   answer[j-1] + answer[j-2]+answer[j-3];
            if(answer[j] > MOD)  {
                answer[j]%=MOD;
            }
        }


    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        out.printLine(answer[in.readInt()]);

    }
}
