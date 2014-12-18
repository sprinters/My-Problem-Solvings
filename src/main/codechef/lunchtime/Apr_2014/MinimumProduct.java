package main.codechef.lunchtime.Apr_2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;
import main.api.my.utils.number.MyIntegerUtils;

import java.math.BigInteger;
import java.util.*;

public class MinimumProduct {
    private static final int MOD    =   1000000007;
    private static Integer[] primes     =   null;
    private static int   upTo       =   20010;

    static {
        primes  = MyIntegerUtils.performSuperFastSieve(upTo);
    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        BigInteger result   =   BigInteger.ONE;
        int elementCount    =   in.readInt();
        int[] elementAt      = IOUtils.readIntArray(in,elementCount);
        for(int i   =   0   ;i < primes.length ; i++) {
            Queue<Integer> heap    =   new PriorityQueue<Integer>
                    (100,new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(o2 > o1) {
                            return 1;
                        } else if(o1 > o2) {
                            return -1;
                        }
                        return 0;
                    }
            });

            int currentPrime    =   primes[i];

            for(int j   =   0;j < elementCount ; j++) {

                int exponent    =   0;
                while(elementAt[j] % currentPrime   ==  0) {
                    elementAt[j]/=currentPrime;
                    exponent++;

                }
                if(exponent > 0)
                    heap.add(exponent);
            }


            while(heap.size() > 1) {

                Integer top =   heap.remove();
                Integer belowTop    =   heap.remove();

                if(top > 1) {
                    heap.add(top-1);
                } if(belowTop > 1) {
                    heap.add(belowTop-1) ;
                }

            }

            if(!heap.isEmpty()) {
                result  = result.multiply(BigInteger.
                        valueOf(currentPrime).pow(heap.remove()).
                        mod(BigInteger.valueOf(MOD)));
            }
        }

        Set<Integer> remainingElement   =   new HashSet<Integer>();
        for(int i   =   0;i < elementCount ; i++) {
            if(elementAt[i] ==  1) {
                continue;
            }

            if(remainingElement.contains(elementAt[i])) {
                remainingElement.remove(elementAt[i]);
                continue;
            }

            remainingElement.add(elementAt[i]);
        }


        for(Integer i : remainingElement) {
            result  =   result.multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(MOD));
        }


        out.printLine(result);


    }
}
