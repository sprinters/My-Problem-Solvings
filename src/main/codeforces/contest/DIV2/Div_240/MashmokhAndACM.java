package main.codeforces.contest.DIV2.Div_240;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MashmokhAndACM {

    private static final int  MOD    =   1000000007;
    private static Map<Integer,List<Long>> divisorTable =  null;

    static {

        divisorTable    =   new HashMap<Integer,List<Long>>();
        for(int     i   =   1;i <=2000;i++) {
            divisorTable.put(i,MyIntegerUtils.getDivisors(i));
        }

    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int k   =   in.readInt();

        int[][] dp  =   new int[k+1][n+1];
        ArrayUtils.fill(dp,0);


        // all sequence of length 1 which are ending with i is only self number.
        for(int i   =   1;i<=n ; i++) {
             dp[1][i]   =   1;
        }


        for(int j   =   2;j <=k ; j++) {
            for(int i   =   1;i<=n ; i++) {

                List<Long> divisors = divisorTable.get(i);
                for(Long l : divisors) {
                    dp[j][i]    +=   dp[j-1][l.intValue()];
                    if(dp[j][i] > MOD) {
                        dp[j][i]-=MOD;
                    }
                }
            }
        }

        int answer =   0;
        for(int j   =   1 ; j<=n ; j++) {
            answer+=dp[k][j];
            if(answer > MOD)  {
                answer-=MOD;
            }
        }

        out.printLine(answer);

    }
}
