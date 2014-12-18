package main.codechef.monthly.MAR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Arrays;

public class TeamSplit {

    private static int MOD  =    1000000;
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int     n   =   in.readInt();
        int     a   =   in.readInt();
        int     b   =   in.readInt();
        int     c   =   in.readInt();
        int     d   =   in.readInt();

        long[]  dp   =   new long[MOD +10];
        long   oldValue,newValue;

        Arrays.fill(dp,0);
        dp[d]++;
        oldValue    =   d;
        for(int i = 1;i < n ; i++) {
            newValue   =   (oldValue * a + b ) % MOD;
            newValue    =   (newValue * oldValue) % MOD;
            newValue    =   (newValue + c) % MOD;

            int index   = (int) (newValue%MOD);
            //out.printLine("newValue is::"+newValue);
            dp[index]++;
            oldValue    =   newValue;
            newValue    =   0;
        }

        long x  =   0,y =   0;
        boolean firstTurn   =   true;
        boolean secondTurn  =   false;
        for(int i   =   MOD ; i >= 0 ; i--) {

            if(dp[i] == 0) {
                continue;
            }
            if(dp[i] > 1) {
                if(dp[i] % 2 == 0) {
                    long count   =   (dp[i] >> 1);
                    x += i*count;
                    y += i*count;

                    firstTurn   =   true;
                    secondTurn  =   false;
                } else {
                    long count   =   (dp[i] >> 1) + 1;
                    x += i*count;
                    y += i*(count-1);

                    firstTurn   =   false;
                    secondTurn  =   true;
                }
            }
            else {
                if(firstTurn) {
                    x += dp[i] * i;
                    firstTurn   =   false;
                    secondTurn  =   true;
                }

                else if(secondTurn) {
                    y += dp[i]*i;
                    secondTurn=false;
                    firstTurn = true;
                }
            }
        }

        out.printLine(Math.abs(x-y));
    }
}
