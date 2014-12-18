package main.hackerearth.adobe;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.HashSet;
import java.util.Set;

public class GameOfNumbers {

    static Set<Long> lookUp    =   new HashSet<Long>();
    static int[] primes    = MyIntegerUtils.generatePrimes(100000);


    public void solve(int testNumber, InputReader in, OutputWriter out) {
                lookUp.clear();
                long from   =   in.readLong();
                long to     =   in.readLong();

                long count  =   0;

                for(int j   =   0;(long)primes[j]*primes[j] <= to && j < primes.length ; j++) {

                    long tmp    =   primes[j]*primes[j];

                    int startIndex  =   getStartPos(from,primes[j]);
                    //out.printLine("startIndex::"+startIndex);
                    for(long k   =   from + startIndex ; k <= to ; k+=primes[j]) {

                       // out.printLine("k="+k);
                        if(k % tmp == 0 && !lookUp.contains(k)) {
                            count++;
                            lookUp.add(k);
                        }
                    }

                }

                out.printLine(to-from+1-count);
            }

            private int getStartPos(long start,long prime) {

                return (start%prime)  ==  0 ? 0 : ((int) (prime - start % prime));
            }

        }


