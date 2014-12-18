package main.codechef.lunchtime.Sep2014;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.ioutils.IOUtils;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChefAndEasyProblem2 {

    private static int MAX_ELEMENT  =   1000000;

    private static Map<Integer,List<Pair<Long,Integer>>> cache =    new HashMap();
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] elementArray  =   IOUtils.readIntArray(in,elementCount);


        int[] mostDisturbing    =   new int[MAX_ELEMENT + 10];

        Arrays.fill(mostDisturbing,0);


        for(int element : elementArray) {

            List<Pair<Long,Integer>> factors    =   null;
            if(cache.containsKey(element)) {
                factors =   cache.get(element);
            } else {
                factors = MyIntegerUtils.factorize(element);
                cache.put(element,factors);
            }
            if(factors  ==  null || factors.isEmpty()) {
                continue;
            }

            for(Pair<Long,Integer> p : factors) {
                mostDisturbing[p.getFirst().intValue()] =   Math.max(mostDisturbing[p.getFirst().intValue()],p.getSecond()) ;
            }
        }


        int result  =   0;
        for(int i  : mostDisturbing) {
            result +=i;
        }
        out.printLine(result);



    }
}
