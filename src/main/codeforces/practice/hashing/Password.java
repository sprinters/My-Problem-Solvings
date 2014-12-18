package main.codeforces.practice.hashing;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import net.egork.chelper.util.InputReader;

public class Password {
    private static int lenCount;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();
        StringHash hasher   =   new ConcreteHasher(input,true);
        lenCount        =   input.length()-1;
        long[] prefixHash   =   new long[input.length() + 1];
        long[] suffixHash   =   new long[input.length() + 1];

        for(int i   =   0;i <= lenCount ;i++) {
            prefixHash[i]   =   hasher.hash(0,i);
            suffixHash[lenCount-i]  =   hasher.hash(lenCount-i,lenCount);
        }

        int longestTillNow  =   -1;
        for(int i   =   lenCount-1;i >=0 ; i--) {

            if(prefixHash[i]    ==  suffixHash[lenCount-i] ) {

                long target =   prefixHash[i];
                int window  =   i+1;
                for(int k   =   1 ; k+i < lenCount ; k++) {

                    long toCompare  =   hasher.hash(k,k+window-1);
                    if(toCompare    ==  target) {
                        longestTillNow  =   Math.max(longestTillNow,window);
                        break;
                    }
                }
            }
        }
        out.printLine(longestTillNow < 0 ? "Just a legend":input.substring(0,longestTillNow));

    }

}
