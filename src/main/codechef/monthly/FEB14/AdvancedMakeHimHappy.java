package main.codechef.monthly.FEB14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.HashMap;
import java.util.Map;

public class AdvancedMakeHimHappy {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N   =   in.readInt();
        int K   =   in.readInt();

        int[] array = IOUtils.readIntArray(in, N);


        Map<Integer,Integer> forwardMap =   new HashMap<Integer,Integer>();
        Map<Integer,Integer> backwardMap =   new HashMap<Integer,Integer>();

        for(int i   =   0;i < N ; i++) {

            if(!forwardMap.containsKey(array[i])) {
                forwardMap.put(array[i],i) ;
            }
        }


        for(int i   =   N-1;i >=0; i--) {

            if(!backwardMap.containsKey(array[i])) {
                backwardMap.put(array[i],i) ;
            }
        }
        int answer  =   Integer.MAX_VALUE;

        for(int i   = 1 ; i < K ; i++) {

            int first   =   i;
            int second  =   K-first;

            if(! (forwardMap.containsKey(first)) || !(backwardMap.containsKey(second))) {
                continue;
            }


            if(first    ==  second) {
                continue;
            }

            int firstIndex  =   forwardMap.get(first);
            int secondIndex =   backwardMap.get(second);


            int firstIndexFromRev   =   backwardMap.get(first);
            int secondIndexFromRev  =   forwardMap.get(second);

            int answer1 =   Math.max(firstIndex+1,secondIndexFromRev+1);
            int answer2 =   Math.max(N-secondIndex ,N-firstIndexFromRev);
            int answer3 =   Math.max(firstIndex+1,N-secondIndex);
            int answer4 =   Math.max(secondIndex+1,N-firstIndex);


            int localMin    =   Math.min(Math.min(answer1,answer2),Math.min(answer3,answer4));

            answer          =   Math.min(answer,localMin);
        }

        out.printLine(answer==Integer.MAX_VALUE ? -1:answer);

    }
}
