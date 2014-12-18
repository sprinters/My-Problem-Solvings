package main.codechef.monthly.OCT14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Arrays;

public class RemyPaintsTheFence {

    private static final long MOD    =   1000000009;
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int plankCount  =   in.readInt();
        int bucketCount =   in.readInt();


        int[] color =   new int[plankCount];
        Arrays.fill(color,'$');
        for(int i   =   0;i < bucketCount ; i++) {

            Character inputColor    =   in.readCharacter();
            int       location      =   in.readInt()-1;
            color[location] =   inputColor;

        }

        int previousAt  =   -1;
        long[] dp   =   new long[plankCount];
        Arrays.fill(dp,1);

        for(int i   =   0;i < plankCount ; i++) {

            if(color[i] != '$') {

                if(previousAt >= 0 && color[i] != color[previousAt]) {
                    dp[i]   =   (dp[previousAt] * (i-previousAt)) % MOD;

                } else {
                    dp[i]   =   dp[previousAt < 0 ? 0 : previousAt];
                }
                previousAt  =   i;
            }
        }

        long result  =   0;
        for(int i   =   plankCount-1 ; i >=0 ; i--) {
            if(color[i] != '$') {
                result  =   dp[i];
                break;
            }
        }
        out.printLine(result);
    }
}
