package main.codechef.monthly.FEB14;

import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeHimHappy {

    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {


        int appleCount  =   in.readInt();
        int targetSum   =   in.readInt();

        int[] appleTypes    = IOUtils.readIntArray(in, appleCount);
        Pair<Integer,Integer>[] appleWithLocation = new Pair[appleCount];
        Set<Pair<Integer,Integer>> dict   =   new HashSet<Pair<Integer,Integer>>();
        // enriching the apple information
        for(int i   =   0;i < appleCount ; i++) {
            appleWithLocation[i]    =   Pair.makePair(appleTypes[i],i);
        }

        Arrays.sort(appleWithLocation);
        //  out.printLine(appleWithLocation);

        // now lets find the two value which has sum equal to targetSum.
        // we will approach this problem using standard algorithm..two pointer approach.

        // define the start and end point

        int start   =   0;
        int end     =   appleCount-1;

        int answer  =   Integer.MAX_VALUE;
        int firstPos    =   0,secondPos =   0;
        // this will indicate that whether two value can be obtained which have sum equal to requireSum.
        // and these value must be distinct.
        boolean status  =   false;
        while(start <= end) {

            int valueAtStart    =   appleWithLocation[start].getFirst();
            int valueAtEnd      =   appleWithLocation[end].getFirst();

            int collectedSum    =   valueAtEnd + valueAtStart;
            if(valueAtStart != valueAtEnd && (collectedSum  ==  targetSum)) {
                status  =   true;
                if(!dict.contains(Pair.makePair(valueAtStart,valueAtEnd))) {
                    answer      =   Math.min(answer, playWithPos(appleCount, start, end,appleWithLocation));
                    dict.add(Pair.makePair(valueAtStart,valueAtEnd));
                }
                start++;
                end--;
                //  continue;
            }
            else if(valueAtEnd  ==  valueAtStart && collectedSum == targetSum) {
                start++;
                end--;
            }
            else if(targetSum > collectedSum) {
                start++;
            } else if(targetSum < collectedSum) {
                end--;
            }
        }

        if(!status) {
            out.printLine(-1);
            return;
        }
        out.printLine(answer);

    }

    public int playWithPos(int appleCount,int start,int end,Pair<Integer,Integer>[] appleWithLocation) {

        int firstPosFrom    =   appleWithLocation[start].getSecond();
        int secondPosFrom   =   appleWithLocation[end].getSecond();

        //out.printLine("first pos from::"+firstPosFrom);
        //out.printLine("second pos from::"+secondPosFrom);

        int firstPosTo      =   start + 1;
        int secondPosTo     =   end-1;

        while(firstPosTo < appleCount) {

            if(appleWithLocation[start].getFirst() == appleWithLocation[firstPosTo].getFirst()) {
                firstPosTo++;
                continue;
            }
            break;
        }
        // out.printLine("before firstPosTo::"+firstPosTo);
        firstPosTo  =   appleWithLocation[firstPosTo-1].getSecond();
        // out.printLine("after firstPosTo::"+firstPosTo);



        while(secondPosTo >= 0) {

            if(appleWithLocation[end].getFirst() == appleWithLocation[secondPosTo].getFirst()) {
                secondPosTo--;
                continue;
            }
            break;
        }


        //  out.printLine("second pos to before::"+secondPosTo);
        secondPosTo =   appleWithLocation[secondPosTo + 1].getSecond();
        //out.printLine("after pos to::"+secondPosTo);
        int answer1 =   Math.max(firstPosFrom,secondPosTo) + 1;

        int answer2 =   Math.max(appleCount-firstPosTo-1,appleCount-secondPosFrom-1) + 1;

        int answer3 =   Math.max(firstPosFrom,appleCount-secondPosFrom-1)+1;

        int answer4 =   Math.max(secondPosFrom,appleCount-firstPosFrom-1)+1;

        int result  =   Math.min(Math.min(answer1,answer2),Math.min(answer3,answer4));

        return result;

    }

}
