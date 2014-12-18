package main.spoj.classical;


import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import net.egork.chelper.util.InputReader;

import java.util.HashMap;
import java.util.Map;

class TheNerdFactor {

    private static Map<Pair<Integer,Integer>,Long> cache    =   null;
    private  static long MOD           =   1000000007;
    private  static int MAX_STUDENT    =   1001;
    private  static int MAX_GROUP_SIZE =   1000;

    static {
        cache   =   new HashMap<Pair<Integer,Integer>,Long>();
        fillChache(cache,MAX_STUDENT,MAX_GROUP_SIZE);

    }

    private static long fillChache(Map<Pair<Integer, Integer>,Long> cache, int n, int k) {

        if(cache.containsKey(Pair.makePair(n,k))) {
            return cache.get(Pair.makePair(n,k)) ;
        }
        //   System.out.println("n   =   "+n+" k="+k);
        if(k < 0 || n < 0) {
            // System.out.println("n or k are less than zero");
            cache.put(Pair.makePair(n,k),0l);
            return 0l;
        }

        if(k > n) {
            //   System.out.println("k becomes greater than n");
            cache.put(Pair.makePair(n,k),0l);
            return 0;
        }  if( k   ==  n) {
            //     System.out.println("k becomes equal to the n");
            cache.put(Pair.makePair(n,k),1l);
        }

        long result = (  fillChache(cache, n, k+1)+fillChache(cache, n-k, k) )% MOD;
        // System.out.println("obtained result is ::"+result);
        cache.put(Pair.makePair(n, k), result);
        return result;
    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int k   =   in.readInt();

        out.printLine(cache.get(Pair.makePair(n,k)));


    }
}

