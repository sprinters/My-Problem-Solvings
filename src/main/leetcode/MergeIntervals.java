package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int intervalCount   =   in.readInt();
        int[] first     =   IOUtils.readIntArray(in,intervalCount);
        int[] second    =   IOUtils.readIntArray(in,intervalCount);

        Pair<Integer,Integer>[] intervals =   new Pair[intervalCount];

        for(int i   =   0;i < intervalCount ; i++) {
            intervals[i]    =   Pair.makePair(first[i],second[i]);
        }

        Arrays.sort(intervals,new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {

                if(o1.getFirst() < o2.getFirst()) {
                    return -1;
                } else if(o1.getFirst() ==  o2.getFirst()) {
                    return o1.getSecond().compareTo(o2.getSecond());
                }
                return 0;
            }
        });


        Stack<Pair<Integer,Integer>> helper = new Stack<Pair<Integer, Integer>>();

        helper.push(intervals[0]);

        for(int i   =   1 ;i < intervals.length ; i++) {

            Pair<Integer,Integer> currentInterval   =   intervals[i];
            Pair<Integer,Integer> stackTop  = helper.peek();
            // look whether we can enrich this interval

            if(currentInterval.getSecond() < stackTop.getFirst())  {
                helper.push(currentInterval);
            } else if(currentInterval.getSecond() < stackTop.getSecond()) {
                // no change have to be made
            } else {

                if(currentInterval.getFirst() < stackTop.getSecond() &&
                        currentInterval.getSecond() > stackTop.getSecond()) {
                    helper.pop();
                    Pair.makePair(stackTop.getFirst(),currentInterval.getSecond());
                }
            }
        }

        for(Pair<Integer,Integer> p : helper) {
            out.printLine(p);
        }
    }
}
