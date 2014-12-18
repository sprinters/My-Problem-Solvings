package main.hackerrank.practice;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class PSequence {
    private static int MOD	=	1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int N	=	in.readInt();
        int P	=	in.readInt();


        int S	=	(int) Math.sqrt(P*1.0);
        int SQP	=	S + 100;

        int[][] dp	=	new int[2][SQP];
        int[][] dpover	=	new int[2][SQP];

        for (int i = 1; i <= S; i++) {
            dp[1][i] = i;
            dpover[1][i] = P/i;
        }
        for (int i = 2; i <= N; ++i){

            int cur = i & 1;
            out.printLine("cur::"+cur);
            int prev = 1 - cur;
                out.printLine("prev::"+prev);
            dp[cur][1] = dpover[prev][1];

            out.print(dp[cur][1]+" ");
            for (int j = 2; j <= S; j++) {

                dp[cur][j] = (dp[cur][j - 1] + dpover[prev][j]) % MOD;
                out.print(dp[cur][j]+" ");
            }


            out.printLine();
            dpover[cur][S+1] = dp[cur][P/(S+1)];

            for (int j = S; j > 0; j--) {
                dpover[cur][j] = (int) ((dpover[cur][j + 1] + (P/j - P/(j+1)) * 1l * dp[prev][j]) % MOD);
            }
        }
        out.printLine(dpover[N&1][1]);
    }
}
