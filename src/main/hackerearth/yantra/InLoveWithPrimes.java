package main.hackerearth.yantra;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.HashSet;
import java.util.Set;

public class InLoveWithPrimes {

    private static Integer[] primes =   null;

    private static Set<Integer> dict    =   new HashSet<Integer>();
    static  {

        primes  = MyIntegerUtils.performSuperFastSieve(100050);
        for(int i : primes) {
            dict.add(i);
        }
    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int num =   in.readInt();

        if(num == 1 || num == 2) {
            out.printLine("Arjit");
            return;
        }

        for(int  i      =   0;i < primes.length && primes[i] <= num ; i++) {
            if(dict.contains(Math.abs(num-primes[i]))) {
                out.printLine("Deepa");
                return;
            }
        }

        out.printLine("Arjit");

    }
}
