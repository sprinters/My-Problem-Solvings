package main.geeksforgeek.dp.longestpalindromicsubsequence;

import main.api.my.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class SolveWithMemorization extends LPSSolver {
    @Override
    public int getLongestPalindromicSubsequence(String array, int from, int to) {
        Map<Pair<Integer,Integer>,Integer> memoMap  =   new HashMap<Pair<Integer,Integer>,Integer>();
        return getLongestPalindromicSubsequence(array,from,to,memoMap);
    }

    private int getLongestPalindromicSubsequence(String array, int from, int to,
                                                 Map<Pair<Integer, Integer>, Integer> memoMap) {
        if(array    ==  null || array.length()  ==  0) {
            return 0;
        }
        if(memoMap.containsKey(Pair.makePair(from,to))) {
            return memoMap.get(Pair.makePair(from,to));
        }

        if(from ==  to) {
            memoMap.put(Pair.makePair(from,to),1);
            return 1;
        }  if(array.charAt(from) == array.charAt(to) && ( from + 1 == to)) {
            memoMap.put(Pair.makePair(from,to),2);
            return 2;
        }
        if(array.charAt(from) == array.charAt(to)) {
            int result  =   2 + getLongestPalindromicSubsequence(array,from+1,to-1,memoMap);
            memoMap.put(Pair.makePair(from,to),result);
            return result;
        }  else  {
            int result  =   Math.max(
                    getLongestPalindromicSubsequence(array,from+1,to,memoMap),
                    getLongestPalindromicSubsequence(array,from,to-1,memoMap)
            ) ;
            memoMap.put(Pair.makePair(from,to),result);
            return result;
        }
    }
}
