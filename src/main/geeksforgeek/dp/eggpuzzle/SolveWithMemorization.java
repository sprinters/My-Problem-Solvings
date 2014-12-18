package main.geeksforgeek.dp.eggpuzzle;

import main.api.my.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class SolveWithMemorization implements EggPuzzleSolver {
    public int getMinTrials(int eggCount, int floorCount) {
        Map<Pair<Integer,Integer>,Integer> memoMap    =   new HashMap<Pair<Integer, Integer>,Integer>();
        return getMinTrials(eggCount, floorCount,memoMap);
    }

    public int getMinTrials(int eggCount,int floorCount,Map<Pair<Integer, Integer>,Integer> memoMap) {

        // check whether this is precalculated problem if yes then just return precalculated answer
        if(memoMap.containsKey(Pair.makePair(eggCount, floorCount))) {
            return memoMap.get(Pair.makePair(eggCount,floorCount));
        }
        // BASE CONDITION
        if(floorCount   ==  0 || floorCount == 1) {

            memoMap.put(Pair.makePair(eggCount,floorCount),floorCount);
            return floorCount;
        }

        // if n == 1 then return k only.
        if(eggCount == 1) {
            memoMap.put(Pair.makePair(eggCount,floorCount),floorCount);
            return floorCount;
        }

        int minTrials   =   Integer.MAX_VALUE;

        for(int from    =   1 ; from <= floorCount ; from ++) {
            int first  =    getMinTrials(eggCount-1,from-1,memoMap);
            int second =    getMinTrials(eggCount,floorCount-from,memoMap);
            int result  =   Math.max(first,second);

            if(result  < minTrials) {
                minTrials   =   result;
            }
            memoMap.put(Pair.makePair(eggCount,floorCount),minTrials+1);

        }
        return minTrials + 1;
    }

}

