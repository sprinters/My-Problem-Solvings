package main.codechef.practice;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import main.utils.io.InputReader;

import java.util.Arrays;

public class RepeatedString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int from    =   in.readInt();
        int to      =   in.readInt();
        if( (from + to)   ==  0) {
            return;
        }

        String input    =   in.readString();

        if(from > to || from > input.length()) {
            out.printLine("0 0");
            return;
        }

        if(to > input.length()) {
            to    =   input.length();
        }

        StringHash hashRef  =   new ConcreteHasher(input,false);
        int low =   from;
        int high  =   to;
        int lenCount    =   input.length();
        long maxOcc     =   getCount(low,hashRef,input.length());
        long maxLength   =   low;

        while(low <= high) {

            int mid =   (low + high) >> 1;
            long count  = getCount(mid,hashRef,lenCount);
            if(count == maxOcc) {
                maxLength   =   mid;
                maxOcc      =   count;
                low         =   mid + 1;
            } else {
                high         =   mid-1;
            }
        }
        out.printLine(maxOcc+" "+maxLength);
    }

    public long getCount(int windowSize,StringHash hashRef,int lenCount) {

        long[] array    =   hashRef.getForwardKSizeHashes(windowSize,lenCount);
        Arrays.sort(array);
        int     count    =  Integer.MIN_VALUE;
        int     maxOccurence  =   1;
        long    from     =  array[0];
        for(int i   =   1 ; i < array.length ; i++) {

            long to =   array[i];
            if(from ==  to) {
                maxOccurence++;
            } else {
                maxOccurence =   1;
                from    =   to;
            }
            count   =   Math.max(count,maxOccurence) ;
        }
        return count <=0 ? 1 : count;
    }
}
