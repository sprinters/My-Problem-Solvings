package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import main.utils.io.InputReader;

import java.util.Arrays;

public class Twice {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int lenCount    =   in.readInt();
        String  input    =   in.readString();

        StringHash hashRef  =   new ConcreteHasher(input,false);
        int low         =   0;
        int high        =   lenCount-1;
        int best        =   0;
        while(low <= high) {

            int mid =   (low + high) >> 1;
            if(isGood(mid,hashRef,lenCount))  {
                best    =   mid;
                low =   mid +1;

            } else {
                high    =   mid-1;
            }
        }
        out.printLine(best);
    }

    private boolean isGood(int mid,StringHash hash,int lenCount) {
        long[] hashes  =   hash.getForwardKSizeHashes(mid,lenCount);
        Arrays.sort(hashes);
        int     count    =  Integer.MIN_VALUE;
        int     maxOccu  =   1;
        long    from     =  hashes[0];
        for(int i   =   1 ; i < hashes.length ; i++) {

            long to =   hashes[i];
            if(from ==  to) {
                maxOccu++;
            } else {
                maxOccu =   1;
                from    =   to;
            }
            count   =   Math.max(count,maxOccu) ;
        }
        return count > 1;
    }
}
