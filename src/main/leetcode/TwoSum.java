package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

        int[] numbers   =   null;
        int target      =   0;
        int[] array =   twoSum(numbers,target);



    }

    private int[] twoSum(int[] numbers, int target) {
        return twoSum(numbers,0,numbers.length, target);
    }

    private int[] twoSum(int[] numbers, int from, int to, int target) {
        Arrays.sort(numbers,from,to);
        Map<Integer,Integer> indexMap   =   new HashMap<Integer,Integer>();
        for(int i=  0;i < numbers.length ; i++) {
            indexMap.put(numbers[i],i+1);
        }


        int first   =   from;
        int second  =   to;
        int[] array =   new int[2];

        while(first <= second) {

            int currentSum  =   numbers[first] + numbers[second];

            if(currentSum == target) {
                array[0]    =   indexMap.get(numbers[first]);
                array[1]    =   indexMap.get(numbers[second]);
                return array;
            }

            else if(currentSum > target) {
                second--;
            }  else {
                first ++;
            }
        }
        return array;
    }
}
