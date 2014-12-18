package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

public class LegoBlocks {

    private static final long MOD = 1000000007;

//    private static long[] f =   new long[1001];
//
//    static {
//
//        for(int i   =   1;i < 1001 ; i++) {
//            f[i]    =   MyIntegerUtils.doMod()
//        }
//    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int targetHeight    =   in.readInt();
        int targetWidth     =   in.readInt();



        long[] f    =   new long[targetWidth + 10];
        long[] g    =   new long[targetWidth + 10];
        long[] h    =   new long[targetWidth + 10];
        /**
         *
         * Consider these definition
         *
         * f(i) = number of ways of covering width upto i and having height 1
         * then
         *
         *          0 if (i < 0)
         *
         *          1 if (i ==  0)
         * f(i) =
         *          f(i-1) + f(i-2) + f(i-3) + f(i-4    ) if(i > 0)
         *
         *
         * g(i) = number of ways of getting all pattern upto width i amd height N ignoring solid conditions
         *
         * then g(i) = (f(i))^N
         *
         *
         *
         */

        //fill base cases for f array

        f[0]  = 1;

        for(int j = 1 ; j <= targetWidth ; j++) {

            if(j-1 >=0) {
                f[j]    = (f[j] +  f[j-1])%MOD;
            }

            if(j-2 >=0) {
                f[j]= (f[j] + f[j-2])%MOD;
            }

            if(j-3 >= 0) {
                f[j]= (f[j] +f[j-3])%MOD;
            }

            if(j-4 >= 0) {
                f[j]=( f[j] + f[j-4] ) % MOD;


            }
        }

        // fill for g array


        for(int i   =   1 ; i <= targetWidth ; i++) {
            g[i]    = MyIntegerUtils.power(f[i]%MOD,targetHeight,MOD);
        }


        // now we have to subtract illegal cases
        /**
         *
         * h(i) =   number of ways of solid walls till width i and height N.
         *
         *
         */

        h[0]    =   g[0];
        h[1]    =   1;

        for(int i   =   2;i <= targetWidth ; i++) {
            h[i]    =   g[i];

            long tmp    =   0;
            for(int j   =   1; j < i ; j++) {
                tmp    =  (tmp +  h[j] * g[i-j])%MOD;
            }

            h[i]    =  ( h[i] - tmp + MOD ) % MOD;

        }

        out.printLine(h[targetWidth]);
    }
    public long getMod(long a,long b,long c) {
    if(b==0) return 1;
        long ret2 = getMod(a, b / 2, MOD);
        ret2 = ret2*ret2%MOD;
        if((b&1)==1) ret2 = 1*a*ret2%MOD;
        return ret2;
    }
}
