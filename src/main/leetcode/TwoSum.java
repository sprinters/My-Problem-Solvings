package main.leetcode;

import main.api.my.pair.Pair;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: sandeepandey
 * Date: 2/2/14
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {

    public static void main(String...s) {
        TwoSum twoSum   =   new TwoSum();
        twoSum.solve();
    }

    private void solve() {

        int[] numbers   =   {0, 4, 3, 0};
        int target      =   0;
        int[] array =   twoSum(numbers,target);

        System.out.println(array[0]+" "+array[1]);


    }

    private int[] twoSum(int[] numbers, int target) {
        return twoSum(numbers,0,numbers.length-1, target);
    }

    private int[] twoSum(int[] numbers, int from, int to, int target) {

        Pair<Integer,Integer>[] pairs = new Pair[numbers.length];
        for(int i   =   0;i < numbers.length ; i++) {
            pairs[i]    =   Pair.makePair(numbers[i],i+1);
        }

        Arrays.sort(pairs,new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getFirst()-o2.getFirst();
            }
        });

        int[] results   =   new int[2];

        while(from < to) {
            int sum =   pairs[from].getFirst() + pairs[to].getFirst();
            if(sum  ==  target) {
                results[0]  = pairs[from].getSecond();
                results[1]  =   pairs[to].getSecond();
                return results;
            } else if(sum > target) {
                to--;
            } else {
                from++;
            }
        }

        return null;
    }
}
