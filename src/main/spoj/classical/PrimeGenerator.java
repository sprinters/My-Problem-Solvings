package main.spoj.classical;

import main.api.my.utils.number.MyIntegerUtils;
import main.utils.io.InputReader;
import main.utils.io.OutputWriter;

import java.util.Arrays;
import java.util.HashSet;

public class PrimeGenerator {

    private static final int MAX_SIZE       =   1000000000;
    private static final int SQRT_LIMIT     = (int) (Math.sqrt(MAX_SIZE*1.0) + 1);
    private static Integer[] primes     =   null;
    private static HashSet<Integer> lookUp  =   new HashSet<Integer>();
    static {
        primes  = MyIntegerUtils.performSuperFastSieve(SQRT_LIMIT);
        for(int i : primes) {
            lookUp.add(i);
        }
    }



    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long start  =   in.readLong();
        long end    =   in.readLong();
        if(start==  1) {
            start++;
        }
        if(start > end) {
            return;
        }
        long[] array    =   new long[(int) (end-start+1)];
        for(int i   =   0; i < (end-start+1) ; i++) {
            array[i]    =   start+i ;
        }

        boolean[] fromChoose    =   doProcess(array);
        for(int i   =   0; i < fromChoose.length ; i++) {
                if(fromChoose[i]) {
                    out.printLine(array[i]);
                }
        }
    }

    private boolean[] doProcess(long[] array) {

        boolean[] helper    =   new boolean[array.length];
        Arrays.fill(helper,true);
        long fromCheck  =   array[array.length-1];
        for(int i   =   0; i < primes.length && (long)(primes[i] * primes[i]) <= fromCheck ; i++) {

            int startPos    =   getStartPos(array[0],primes[i]);
           // System.out.println("startpos ::"+array[startPos]);
            if((lookUp.contains(array[startPos]))) {
                startPos += primes[i];
               // System.out.println("startpos ::"+startPos);
            }
            for(int j   =   startPos ; j < array.length ; j+=primes[i]) {
                 helper[j]  =   false;
            }
        }
        return helper;





    }

    private int getStartPos(long start,long prime) {

        return (start%prime)  ==  0 ? 0 : ((int) (prime - start % prime));
    }
}
