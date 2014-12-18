package main.codechef.monthly.NOV13;

import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;
import net.egork.chelper.util.InputReader;

import java.util.HashSet;
import java.util.Set;

public class YetAnotherCuteGirl {

    private static int[] primes          =   null;
    private static final int    UPTO            =   1000000;
    private static long[]       bufferArray     =   null;
    private static long[]       factorArray     =   null;
    private static Set<Long> lookUp          =   new HashSet<Long>();
    static {
        primes                                  =   MyIntegerUtils.generatePrimes(UPTO);
       // lookUp.addAll(Arrays.asList(primes));
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long from       =   in.readLong();
        long to         =   in.readLong();
        int size        =   (int) ((int)to-from + 1);
        bufferArray     =   new long[size];
        factorArray     =   new long[size];
        long start      =   from;
        for(int i   =   0;i < size ; i++) {
            bufferArray[i]  =  start;
            start           +=1;
            factorArray[i]  =   1;
        }

        long[] divisors =   getDivisorArray(bufferArray,factorArray,from,to);
        long answer =   0;
        for(long  i : divisors) {
            if(lookUp.contains((int)i)) {
                answer++;
            }
        }
        out.printLine(answer);
    }

    private long[] getDivisorArray(long[] bufferArray, long[] factorArray, long from, long to) {

        for(int fix =   0;fix < primes.length && (primes[fix] * primes[fix]) <= to  ; fix ++) {
            long currentPrime    =   primes[fix];
            long start   =   getStartPoint(from,currentPrime);
            for(int i   =   (int)start ; i < (to-from + 1) ; i+=currentPrime) {
                long dummy      =   bufferArray[i];
                Entry entry     =   getDivisorCount(dummy,currentPrime);
                factorArray[i]  =   factorArray[i] * (entry.getDiv() + 1);
                bufferArray[i]  =   entry.getRem();
            }
        }
        for(int i   =   0;i < (to-from + 1) ; i++) {

            if(bufferArray[i] > 1) {
                factorArray[i] = factorArray[i] * 2;
            }
        }
        return factorArray;
    }

    private Entry getDivisorCount(long toDivide, long fromDivide) {

        int count   =   0;

        while((toDivide) > 0 && (toDivide % fromDivide     ==  0)  ) {
            count++;
            toDivide/=fromDivide;
        }
        return new Entry(count,toDivide);
    }

    private long getStartPoint(long from, long prime) {

        int tmp = from % prime ==0 ? 0 : (int) (prime - from % prime);
        return tmp;
    }

    private static class Entry {
        private int div;
        private long rem;

        public Entry(int div,long rem) {
            this.div    =   div;
            this.rem    =   rem;
        }

        public int getDiv() {
            return div;
        }
        public long getRem() {
            return rem;
        }

        public String toString() {
            return "Div::"+getDiv()+
                    " Rem::"+getRem();
        }
    }
}
