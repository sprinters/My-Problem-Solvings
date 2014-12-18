package main.hackerearth.mobile91;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.mis.filter.Filter;

import java.util.Arrays;

public class RKString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int firstCount  =   in.readInt();
        int secondCount =   in.readInt();
        char[] typeArray    =   in.readString().toCharArray();

        if(firstCount   ==  1) {
            int[] requiredPositions = ArrayUtils.filterIndexes(typeArray,new Filter<Character>() {
                @Override
                public boolean accept(Character sample) {
                    if(sample   ==  'R')
                        return true;
                    return false;
                }
            });

            out.print(followSpecialRoutine(requiredPositions,'R',typeArray.length));

        } else {
            out.print(getSubstring(firstCount, 'R', typeArray,out));
        }

        if(secondCount  ==  1) {

            int[] requiredPositions =   ArrayUtils.filterIndexes(typeArray,new Filter<Character>() {
                @Override
                public boolean accept(Character sample) {
                    if(sample   ==  'K')
                        return true;
                    return false;
                }
            })      ;

            out.print(" "+ followSpecialRoutine(requiredPositions, 'K',typeArray.length));


        } else {
            out.print(" "+getSubstring(secondCount, 'K', typeArray,out));
        }
    }

    private long followSpecialRoutine(int[] requiredPositions,char toWatch,int length) {

        if(requiredPositions  ==    null || requiredPositions.length    ==  0) {
            return 0;
        }


        int left,right,segmentStart,segmentEnd;
        if(requiredPositions.length ==  1) {

            left    =   requiredPositions[0];
            right   =   requiredPositions.length-requiredPositions[0];

            return left + right + (left * right) + 1;
        }

        segmentStart    =   requiredPositions[0];
        segmentEnd      =   requiredPositions[1];

        long total          =   0;

        left    =   segmentStart;
        right   =   (requiredPositions.length    ==  2 ? length: requiredPositions[2])-segmentEnd-1;

        total   +=   left + right + (left * right) + 1;

        for(int from    =   1;from < requiredPositions.length ; from++) {

            left    =   segmentEnd-segmentStart-1;
            if(left < 0) {
                left    =   0;
            }


            if(from + 1 >= requiredPositions.length) {
                right   =   length-requiredPositions.length-1;
            } else {
                right   =   requiredPositions[from+1]-segmentEnd-1;
            }

            if(right < 0) {
                right   =   0;
            }

            total += left + right + (left * right) + 1;
            segmentStart    =   segmentEnd;
            segmentEnd      =   from+1 >= requiredPositions.length ? requiredPositions.length :requiredPositions[from];
        }

        return total;
    }


    public long getSubstring(int desiredCount,char toMatch,char[] typeArray,OutputWriter out) {

        long totalSubstring =   0;
        int[] nextMatchAt   =   getMatchingArray(typeArray,toMatch);
        int segmentStart    =   -1;
        int segmentEnd      =    -1;
        for(int j   =   0;j < typeArray.length ; j++) {
            if(toMatch  ==  typeArray[j]) {
                segmentStart    =   j;
                break;
            }
        }

        if(segmentStart ==  -1) {
            return 0l;
        }

        int tmpCount    =   0;
        for(int j   =   segmentStart  ; j < typeArray.length ; j++) {

            if(typeArray[j] ==  toMatch) {
                tmpCount++;
            }

            if(tmpCount ==  desiredCount) {
                segmentEnd  =   j;
                break;
            }
        }

        if(segmentEnd == -1 && desiredCount > 1) {
            return 0;
        }
        // till now we have segmentStart and segmentEnd which has valid number of matching char.

        int canBeExtendedTill   =   nextMatchAt[segmentEnd]-segmentEnd-1;
        totalSubstring =    segmentStart + canBeExtendedTill + (segmentStart * canBeExtendedTill) + 1;
        for(int j   =   nextMatchAt[segmentEnd] ; j < typeArray.length ; ) {

            int midCharCount    =   segmentEnd-segmentStart-1;
            if(midCharCount < 0) {
                midCharCount    =   0;
            }

            segmentStart        =   segmentEnd;
            segmentEnd          =   j;

            canBeExtendedTill   =   (segmentEnd  ==  typeArray.length ? segmentEnd :nextMatchAt[segmentEnd])-segmentEnd -1;
            totalSubstring+=midCharCount + canBeExtendedTill+(midCharCount * canBeExtendedTill)+1;
            j                   =   segmentEnd;

        }
        return totalSubstring;
    }

    public int[] getMatchingArray(char[] typedArray,char toMatch) {


        int[] nextMatchAt   =   new int[typedArray.length];
        Arrays.fill(nextMatchAt,typedArray.length);
        int lastAt  =   typedArray.length;

        for(int j   =   typedArray.length-1; j>=0 ;j--) {

            if(toMatch  ==  typedArray[j]) {
                nextMatchAt[j]  =   lastAt;
                lastAt  =   j;
                continue;
            }
            nextMatchAt[j]  =   lastAt;
        }

        return nextMatchAt;

    }
}
